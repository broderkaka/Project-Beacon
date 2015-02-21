package org.beacon.tvdbapi;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

public class TVDBapi {

    final static Logger logger = LoggerFactory.getLogger(TVDBapi.class);

    public ArrayList<TVShow> getTVShows(String tvShowName) {
        ArrayList<TVShow> tvShows = new ArrayList<>();
        try
        {
            TVShowSearcher sp = new TVShowSearcher();
            tvShows = sp.search(tvShowName);
        } catch (ParserConfigurationException | SAXException | IOException e)
        {
            logger.error("{}", e );
        }
        return tvShows;
    }
}
