package org.beacon.tvdbapi;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class TVDBapi {

    private static final String apiKey = "040D2018CD1FCCD2";

    public ArrayList<TVShow> getTVShows(String tvShowName)
    {
        ArrayList<TVShow> tvShows = new ArrayList<>();
        try {
            TVShowSearchParser sp = new TVShowSearchParser();
            tvShows = sp.search(tvShowName);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tvShows;
    }
}