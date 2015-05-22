package org.beacon.torrentfinder;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by marcus.oberg on 2015-05-06.
 */
public class Torrent {

    @JsonProperty("titel")
    private String titel;
    @JsonProperty("seeds")
    private String seeds;
    @JsonProperty("leechs")
    private String leechs;
    @JsonProperty("size")
    private String size;
    @JsonProperty("hash")
    private String hash;
    public Torrent(String titel, String seeds, String leechs, String size, String hash) {
        this.titel = titel;
        this.seeds = seeds;
        this.leechs = leechs;
        this.size = size;
        this.hash = hash;
    }
    public Torrent() {

    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getSeeds() {
        return seeds;
    }

    public void setSeeds(String seeds) {
        this.seeds = seeds;
    }

    public String getLeechs() {
        return leechs;
    }

    public void setLeechs(String leechs) {
        this.leechs = leechs;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
