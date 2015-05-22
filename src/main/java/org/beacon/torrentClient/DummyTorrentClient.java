package org.beacon.torrentClient;

import org.beacon.torrentfinder.Torrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DummyTorrentClient implements TorrentClient {

    ConcurrentHashMap<String, TorrentStatus> client = new ConcurrentHashMap<>();

    public DummyTorrentClient() {
        new Thread(new Update()).run();
    }

    @Override
    public void addTorrent(Torrent torrent) {
        client.put(torrent.getHash(), new TorrentStatus());
    }

    @Override
    public TorrentStatus getStatus(Torrent torrent) {
        return client.get(torrent.getHash());
    }

    private class Update implements Runnable {
        @Override
        public void run() {
            while (true) {
                for (Map.Entry<String, TorrentStatus> pair : client.entrySet()) {
                    TorrentStatus status = pair.getValue();
                    if (status.getProgress().equals("100")) {
                        status.setStatus("Done");
                    } else {
                        status.setProgress(Integer.parseInt(status.getProgress()) + 1 + "");
                    }
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
