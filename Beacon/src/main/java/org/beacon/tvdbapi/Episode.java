package org.beacon.tvdbapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Episode {
    @JsonProperty("episode_id")
	private String id;
    @JsonProperty("episode_name")
	private String episodeName;
    @JsonProperty("episode_number")
	private String episodeNumber;
    @JsonProperty("episode_firstAired")
	private String firstAired;
    @JsonProperty("episode_language")
	private String language;
    @JsonProperty("episode_seasonNumber")
	private String seasonNumber;
    @JsonProperty("episode_lastUpdated")
	private String lastUpdated;
    @JsonProperty("episode_seasonid")
	private String seasonID;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEpisodeName() {
		return episodeName;
	}

	public void setEpisodeName(String episodeName) {
		this.episodeName = episodeName;
	}

	public String getEpisodeNumber() {
		return episodeNumber;
	}

	public void setEpisodeNumber(String episodeNumber) {
		this.episodeNumber = episodeNumber;
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

	public String getSeasonNumber() {
		return seasonNumber;
	}

	public void setSeasonNumber(String seasonNumber) {
		this.seasonNumber = seasonNumber;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getSeasonID() {
		return seasonID;
	}

	public void setSeasonID(String seasonID) {
		this.seasonID = seasonID;
	}
}
