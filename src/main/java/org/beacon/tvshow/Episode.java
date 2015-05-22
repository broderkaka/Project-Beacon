package org.beacon.tvshow;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.beacon.tvdb.gen.getSerie.FullSerie;

import java.text.SimpleDateFormat;
import java.util.Random;

public class Episode {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("number")
    private int number;
    @JsonProperty("firstAired")
    private String firstAired;
    @JsonProperty("language")
    private String language;
    @JsonProperty("seasonNumber")
    private int seasonNumber;
    @JsonProperty("episode_lastUpdated")
    private int lastUpdated;
    @JsonProperty("episode_seasonid")
    private short seasonID;
    @JsonProperty("progress")
    private String progress = new Random().nextInt(100) + "";

    public static Episode fromFullSerieEpisode(FullSerie.Episode episode) {
        Episode ep = new Episode();
        ep.id = episode.getId();
        ep.name = episode.getEpisodeName();
        ep.number = episode.getEpisodeNumber();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(episode.getFirstAired().toGregorianCalendar().getTime());
        ep.firstAired = dateString;
        ep.language = episode.getLanguage();
        ep.seasonNumber = episode.getSeasonNumber();
        ep.lastUpdated = episode.getLastupdated();
        ep.seasonID = episode.getSeasonid();
        return ep;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFirstAired() {
        return firstAired;
    }

    public void setFirstAired(String firstAired) {
        this.firstAired = firstAired;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public int getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(int lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public short getSeasonID() {
        return seasonID;
    }

    public void setSeasonID(short seasonID) {
        this.seasonID = seasonID;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }
}
