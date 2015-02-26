package org.beacon.torrentfinder;

public class Torrent {
	
	private String title;
	private String magnetLink;
	private String seeders;
	private String leechers;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMagnetLink() {
		return magnetLink;
	}
	public void setMagnetLink(String magnetLink) {
		this.magnetLink = magnetLink;
	}
	public String getSeeders() {
		return seeders;
	}
	public void setSeeders(String seeders) {
		this.seeders = seeders;
	}
	public String getLeechers() {
		return leechers;
	}
	public void setLeechers(String leechers) {
		this.leechers = leechers;
	}

	public boolean hasValues()
	{
		return title != null & magnetLink != null && seeders != null && leechers != null;
	}


}
