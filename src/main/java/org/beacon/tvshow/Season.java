package org.beacon.tvshow;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.beacon.tvdb.gen.banners.Banners;
import org.beacon.tvdb.gen.getSerie.FullSerie;

import java.util.ArrayList;

public class Season {
    @JsonProperty("season_number")
    private int number;
    @JsonProperty("season_id")
    private int id;
    @JsonProperty("season_banner")
    private ArrayList<Banners.Banner> banners;
    @JsonProperty("season_episodes")
    private ArrayList<Episode> episodes;

    private Season() {
        episodes = new ArrayList<>();
        banners = new ArrayList<>();
    }

    public static Season fromFullSerieEpisode(FullSerie.Episode episode) {
        Season season = new Season();
        season.id = episode.getSeasonid();
        season.number = episode.getSeasonNumber();
        return season;
    }

    public void setSeasonId(Episode episode) {
        this.id = episode.getSeasonID();
    }

    public ArrayList<Banners.Banner> getBanners() {
        return banners;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public void addEpisode(FullSerie.Episode episode) {
        episodes.add(Episode.fromFullSerieEpisode(episode));
    }

    public void addBanner(Banners.Banner banner) {
        if (banner != null) {
            this.banners.add(banner);
        }
    }
}
