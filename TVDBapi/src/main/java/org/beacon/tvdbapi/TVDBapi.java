package org.beacon.tvdbapi;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.beacon.tvdbapi.DataTypes.TVShow;
import org.xml.sax.SAXException;

public class TVDBapi {

    final static Logger logger = Logger.getLogger(TVDBapi.class);

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
