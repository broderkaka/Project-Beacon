package org.beacon.Database;

import org.beacon.tvdb.gen.getSerie.FullSerie;

import java.util.ArrayList;

public class MyTvShows {
    private static ArrayList<FullSerie> myTVShows = new ArrayList<>();

    public static synchronized ArrayList<FullSerie> getTVShows() {
        return myTVShows;
    }

    public static synchronized void addTVShows(FullSerie tvShow) {
        myTVShows.add(tvShow);
    }
}
