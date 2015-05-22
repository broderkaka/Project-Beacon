package org.beacon.torrentfinder;

import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class DummyTorrentFinder implements TorrentFinder {
    @Override
    public List<Torrent> searchTorrents(String query) {
        List<Torrent> res = new ArrayList<>();
        res.add(new Torrent("dymmy1", "5", "3", "12345", getRandomHash()));
        res.add(new Torrent("dymmy2", "55", "43", "12345", getRandomHash()));
        res.add(new Torrent("dymmy3", "52", "32", "12345", getRandomHash()));
        res.add(new Torrent("dymmy4", "45", "13", "12345", getRandomHash()));
        res.add(new Torrent("dymmy5", "75", "38", "12345", getRandomHash()));
        return res;
    }

    private String getRandomHash() {
        return new Base32(true).encodeToString(DigestUtils.sha1(UUID.randomUUID().toString()));
    }
}
