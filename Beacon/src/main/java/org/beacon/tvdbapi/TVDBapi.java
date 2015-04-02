package org.beacon.tvdbapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.xml.stream.XMLStreamException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TVDBapi {

	final static Logger logger = LoggerFactory.getLogger(TVDBapi.class);

	public ArrayList<TVShowTemplate> searchTVShows(String tvShowName) {
		ArrayList<TVShowTemplate> tvShows = new ArrayList<>();
		try {
			TVShowTemplateSearcher sp = new TVShowTemplateSearcher();
            tvShows = sp.search(tvShowName);
            ShowBannerFetcher bf = new ShowBannerFetcher();
            ExecutorService exec = Executors.newCachedThreadPool();
            for(TVShowTemplate show:tvShows)
            {
                exec.submit(new populateBanners(show));
            }
            exec.shutdown();
            for(int i = 0; i <= 5;i++)
            {
                try {
                    exec.awaitTermination(10, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    logger.info("Fetch banner took some time: %d s. Will wait 60 sec", i*10);
                }
            }


		} catch (IOException | XMLStreamException e) {
			logger.error("Failed to search for TVShow %s: %s", tvShowName, e.getMessage());
		}
		return tvShows;
	}

    public TVShow populateTVShow(TVShowTemplate template)
    {
        ArrayList<TVShow> tvshows = new ArrayList<>();
        try {
            tvshows = new TVShowSearcher().search(template.getName());
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        TVShow show = null;
        for (TVShow tvshow: tvshows)
        {
            if(tvshow.getId().equalsIgnoreCase(template.getId()))
            {
                show = tvshow;
            }
        }
        if(show == null)
        {
            //logg
            return null;
        }
        EpisodesSearcher epSearch = new EpisodesSearcher();
        try {
            epSearch.loadEpisodes(show);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BannerFetcher bf =  new BannerFetcher();
        try {
            bf.fetchBanner(show);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return show;
    }
    
    private class populateBanners implements Runnable{
        private final TVShowTemplate tvshow;

        protected populateBanners(TVShowTemplate tvshow)
        {
            this.tvshow = tvshow;
        }

        @Override
        public void run() {
            ShowBannerFetcher bf = new ShowBannerFetcher();
            try {
                bf.fetchShowBanner(tvshow);
            } catch (XMLStreamException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}