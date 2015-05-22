package org.beacon.torrentfinder;

import java.util.List;

/**
 * Created by marcus.oberg on 2015-05-06.
 */
public interface TorrentFinder {

    List<Torrent> searchTorrents(String query);
}
