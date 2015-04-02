package org.beacon.tvdbapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TVShowTemplate {
    @JsonProperty("show_id")
    private String id;
    @JsonProperty("show_language")
    private String lang;
    @JsonProperty("show_name")
    private String name;
    @JsonProperty("show_year")
    private String firstAired;
    @JsonProperty("show_banner")
    private String banner;

    public String getFirstAired() {
        return firstAired;
    }

    public void setFirstAired(String firstAired) {
        this.firstAired = firstAired;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String bannerPath) {
        if (bannerPath != null) {
            this.banner = "http://thetvdb.com/banners/" + bannerPath;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }




}
