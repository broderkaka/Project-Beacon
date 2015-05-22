package org.beacon.tvshow;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.beacon.tvdb.gen.banners.Banners;
import org.beacon.tvdb.gen.getSerie.FullSerie;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Keep a record of a TVShow
 */
public class TVShow {
    @JsonProperty("id")
    private int id;
    @JsonProperty("language")
    private String lang;
    @JsonProperty("name")
    private String name;
    @JsonProperty("banner")
    private ArrayList<Banners.Banner> banners;
    @JsonProperty("fanart")
    private ArrayList<Banners.Banner> fanart;
    @JsonProperty("posters")
    private ArrayList<Banners.Banner> posters;
    @JsonProperty("year")
    private String firstAired;
    @JsonProperty("seasons")
    private HashMap<Integer, Season> seasons;


    private TVShow() {
        this.seasons = new HashMap<>();
        this.banners = new ArrayList<>();
        this.fanart = new ArrayList<>();
        this.posters = new ArrayList<>();
    }

    public static TVShow fromFullSerie(FullSerie fullSerie) {
        TVShow tvshow = new TVShow();
        FullSerie.Series series = fullSerie.getSeries();
        tvshow.id = series.getId();
        tvshow.lang = series.getLanguage();
        tvshow.name = series.getSeriesName();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(series.getFirstAired().toGregorianCalendar().getTime());
        tvshow.firstAired = dateString;
        for (FullSerie.Episode episode : fullSerie.getEpisode()) {
            if (!tvshow.seasons.containsKey(episode.getSeasonid())) {
                Season season = Season.fromFullSerieEpisode(episode);
                tvshow.seasons.put(season.getNumber(), season);
            }
            tvshow.seasons.get(episode.getSeasonNumber()).addEpisode(episode);
        }
        for (Banners.Banner banner : fullSerie.getBanners().getBanner()) {
            if (banner.getBannerType().equals("series")) {
                tvshow.banners.add(banner);
            }
            if (banner.getBannerType().equals("season")) {
                tvshow.seasons.get(banner.getSeason()).addBanner(banner);
            }
            if (banner.getBannerType().equals("fanart")) {
                tvshow.fanart.add(banner);
            }
            if (banner.getBannerType().equals("poster")) {
                tvshow.posters.add(banner);
            }
        }
        return tvshow;
    }
}
