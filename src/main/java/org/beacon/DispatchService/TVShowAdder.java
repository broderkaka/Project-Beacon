package org.beacon.DispatchService;

import org.beacon.Database.MyTvShows;
import org.beacon.tvdb.TVDBapi;
import org.beacon.tvdb.gen.getSerie.FullSerie;
import org.beacon.tvshow.TVShowTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
            FullSerie newTvShow = tvdBapi.getTemplate(tvShow);
            if (newTvShow != null) {
                MyTvShows.addTVShows(newTvShow);
            }
        } else {
            logger.error("Tried to add tvshow that was null");
        }
    }
}
