package org.beacon.torrentfinder;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.xml.stream.XMLStreamException;

import org.beacon.tvdbapi.Episode;
import org.beacon.tvdbapi.TVShow;
import org.junit.Test;

public class TestTPBSearcher {

	@Test
	public void test() throws XMLStreamException, IOException {
		TVShow t = new TVShow();
		t.setName("The big bang theory");
		Episode e = new Episode();
		e.setEpisodeNumber("2");
		e.setSeasonNumber("12");
		new ThePirateBaySearcher().findTorrents(t, e);
	}

}
