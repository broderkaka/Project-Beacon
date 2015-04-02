package org.beacon.DispatchService;

import org.beacon.Database.MyTvShows;
import org.beacon.tvdbapi.TVDBapi;
import org.beacon.tvdbapi.TVShow;
import org.beacon.tvdbapi.TVShowTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class TVShowAdder implements Runnable {
    final static Logger logger = LoggerFactory.getLogger(TVShowAdder.class);
    private final TVShowTemplate tvShow;

    public TVShowAdder(TVShowTemplate tvShow) {

        this.tvShow = tvShow;

    }

    @Override
    public void run() {
            if (tvShow != null) {
                TVDBapi tvdBapi = new TVDBapi();
                TVShow newTvShow = tvdBapi.populateTVShow(tvShow);
                if(newTvShow != null) {
                    MyTvShows.addTVShows(newTvShow);
                }
            }
            else
            {
                logger.error("Tried to add tvshow that was null");
            }
    }
}
