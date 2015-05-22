package org.beacon.tvdb;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Season {
    @JsonProperty("season_number")
    private String number;
    @JsonProperty("season_id")
    private String id;
    @JsonProperty("season_banner")
    private ArrayList<String> banners;
    @JsonProperty("season_episodes")
    private ArrayList<Episode> episodes;

    public Season(Episode episode) {
        this.id = episode.getSeasonID();
        this.number = episode.getSeasonNumber();
        episodes = new ArrayList<>();
        banners = new ArrayList<>();
    }

    public void setSeasonId(Episode episode) {
        this.id = episode.getSeasonID();
    }

    public ArrayList<String> getBanners() {
        return banners;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addEpisode(Episode episode) {
        episodes.add(episode);
    }

    public void addBanner(String bannerPath) {
        if (bannerPath != null) {
            this.banners.add("http://thetvdb.com/banners/" + bannerPath);
        }
    }
}
