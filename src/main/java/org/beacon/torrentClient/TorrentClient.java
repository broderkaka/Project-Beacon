package org.beacon.torrentClient;

import org.beacon.torrentfinder.Torrent;

public interface TorrentClient {

    void addTorrent(Torrent torrent);

    TorrentStatus getStatus(Torrent torrent);
}
