package org.beacon.tvshow;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.beacon.tvdb.TVDBapi;
import org.beacon.tvdb.gen.searchSeries.SeriesList;

import java.text.SimpleDateFormat;

public class TVShowTemplate {
    @JsonProperty("seriesid")
    private Integer seriesId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("language")
    private String language;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("banner")
    private String banner;
    @JsonProperty("firstAired")
    private String firstAired;
    @JsonProperty("network")
    private String network;
    @JsonProperty("zap2ItId")
    private String zap2itID;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("imdbid")
    private String imdbID;
    @JsonProperty("aliasNames")
    private String adliasName;

    public Integer getSeriesId() {
        return seriesId;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public String getOverview() {
        return overview;
    }

    public String getBanner() {
        return banner;
    }

    public String getFirstAired() {
        return firstAired;
    }

    public String getNetwork() {
        return network;
    }

    public String getZap2itID() {
        return zap2itID;
    }

    public Integer getId() {
        return id;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getAdliasName() {
        return adliasName;
    }

    public static TVShowTemplate fromSeries(SeriesList.Series series) {
        TVShowTemplate tvshow = new TVShowTemplate();
        tvshow.seriesId = series.getSeriesid();
        tvshow.name = series.getSeriesName();
        tvshow.language = series.getLanguage();
        tvshow.overview = series.getOverview();
        tvshow.banner = TVDBapi.MIRROR_PATH + "banners/" + series.getBanner();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(series.getFirstAired().toGregorianCalendar().getTime());
        tvshow.firstAired = dateString;

        tvshow.network = series.getNetwork();
        tvshow.id = series.getId();
        tvshow.zap2itID = series.getZap2ItId();
        tvshow.imdbID = series.getIMDBID();
        tvshow.adliasName = series.getAliasNames();
        return tvshow;
    }
}
