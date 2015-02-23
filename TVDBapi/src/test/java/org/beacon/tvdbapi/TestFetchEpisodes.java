package org.beacon.tvdbapi;

import java.io.IOException;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;

public class TestFetchEpisodes {

	@Test
	public void test() throws IOException, XMLStreamException {
		for (Episode ep : new EpisodesSearcher().loadEpisodes("80379")) {
			System.out.println(ep.getEpisodeName() + " " + ep.getFirstAired());
		}
	}

}
