package org.beacon.tvdbapi;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Keep a record of a TVShow
 */
public class TVShow {
    @JsonProperty("show_id")
    private String id;
    @JsonProperty("show_language")
    private String lang;
    @JsonProperty("show_name")
    private String name;
    @JsonProperty("show_banner")
    private ArrayList<String> banners;
    @JsonProperty("show_year")
    private String firstAired;
    @JsonProperty("show_seasons")
    private HashMap<String, Season> seasons;


    public TVShow() {
        this.seasons = new HashMap<>();
        this.banners = new ArrayList<>();
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
        Season season = seasons.get(episode.getSeasonNumber());
        if (season == null) {
            season = new Season(episode);
            seasons.put(season.getNumber(), season);
        }
        season.addEpisode(episode);
    }

    public void addShowBanner(String bannerPath) {
        if (bannerPath != null) {
            this.banners.add("http://thetvdb.com/banners/" + bannerPath);
        }
    }

    public void setFirstAired(String content) {

        firstAired = content;
    }

    public void addSeasonBanner(String bannerPath, String seasonNumber) {
        Season season = seasons.get(seasonNumber);
        if (season != null) {
            //logg
        }

        season.addBanner(bannerPath);
    }
}
