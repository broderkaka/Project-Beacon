package org.beacon.tvdbapi.datatypes;

import java.util.ArrayList;

/**
 * Keep a record of a TVShow
 */
public class TVShow {

    private String id;
    private String lang;
    private String name;
    private ArrayList<Episode> episodes;

    public TVShow() {
        this.episodes = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addEpisode(Episode episode) {
        this.episodes.add(episode);
    }
}
