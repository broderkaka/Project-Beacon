package org.beacon.DispatchService;

import org.beacon.torrentClient.DummyTorrentClient;
import org.beacon.torrentClient.TorrentStatus;
import org.beacon.torrentfinder.Torrent;
import org.beacon.tvdb.gen.searchSeries.SeriesList;
import org.beacon.tvshow.TVShowTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Dispacher {
    private static ExecutorService exec = Executors.newCachedThreadPool();
    private static DummyTorrentClient torrentClient = new DummyTorrentClient();

    public static void addTVShow(TVShowTemplate tvShow) {
        exec.submit(new TVShowAdder(tvShow));
    }

    public static void downloadEpisode(Torrent torrent) {
        torrentClient.addTorrent(torrent);
    }

    public static TorrentStatus getTorrentStatus(Torrent torrent) {
        return torrentClient.getStatus(torrent);
    }
}
