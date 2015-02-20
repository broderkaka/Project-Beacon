package org.beacon.tvdbapi;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class TVDBapi {

    public ArrayList<TVShow> getTVShows(String tvShowName) {
        ArrayList<TVShow> tvShows = new ArrayList<>();
        try
        {
            TVShowSearcher sp = new TVShowSearcher();
            tvShows = sp.search(tvShowName);
        } catch (ParserConfigurationException | SAXException | IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tvShows;
    }
}
