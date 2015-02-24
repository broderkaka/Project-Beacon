package org.beacon.tvdbapi;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.stream.XMLStreamException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TVDBapi {

	final static Logger logger = LoggerFactory.getLogger(TVDBapi.class);

	public ArrayList<TVShow> getTVShows(String tvShowName) {
		ArrayList<TVShow> tvShows = new ArrayList<>();
		try {
			TVShowSearcher sp = new TVShowSearcher();
			tvShows = sp.search(tvShowName);
		} catch (IOException | XMLStreamException e) {
			logger.error("Failed to search for TVShow %s: %s",tvShowName, e.getMessage());
		}
		return tvShows;
	}
}
