package org.beacon.Database;

import org.beacon.tvdbapi.TVShow;

import java.util.ArrayList;

public class MyTvShows {
    private static ArrayList<TVShow> myTVShows = new ArrayList<>();

    public static synchronized ArrayList<TVShow> getTVShows()
    {
        return myTVShows;
    }

    public static synchronized void addTVShows(TVShow tvShow){
        myTVShows.add(tvShow);
    }
}
