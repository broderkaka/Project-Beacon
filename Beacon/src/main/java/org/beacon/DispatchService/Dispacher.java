package org.beacon.DispatchService;

import org.beacon.tvdbapi.TVShow;
import org.beacon.tvdbapi.TVShowTemplate;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Dispacher {
    private  static ExecutorService exec = Executors.newCachedThreadPool();

    public static void addTVShow(TVShowTemplate tvShow)
    {
        exec.submit(new TVShowAdder(tvShow));
    }
}
