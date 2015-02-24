package org.beacon.tvdbapi;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Get a list of TVshows matching a search term from The TVDB. TVDB returns a
 * XML document with all matching shows. The XML is parsed with a SAXparser. The
 * See The TVDB wiki for XML reference.
 */

public class TVShowSearcher {

	private XMLInputFactory factory;

	private final String SERIES = "series";
	private final String SERIESID = "seriesid";
	private final String LANGUAGE = "language";
	private final String SERIESNAME = "seriesname";
	private static final String apiUrl = "http://www.thetvdb.com/api/GetSeries.php?seriesname=";

	final static Logger logger = LoggerFactory.getLogger(TVShowSearcher.class);

	public TVShowSearcher() {
		factory = XMLInputFactory.newInstance();
	}

	public ArrayList<TVShow> search(String tvShowName)
			throws XMLStreamException, IOException {
		URL url = new URL(apiUrl + tvShowName);
		XMLStreamReader reader = factory
				.createXMLStreamReader(url.openStream());
		ArrayList<TVShow> tvShows = new ArrayList<>();
		while (reader.hasNext()) {
			if (reader.next() == XMLStreamConstants.START_ELEMENT) {
				if (SERIES.equals(reader.getLocalName().toLowerCase())) {
					tvShows.add(parseTVShow(reader));
				}
			}
		}
		return tvShows;
	}

	private TVShow parseTVShow(XMLStreamReader reader)
			throws XMLStreamException {
		TVShow tvshow = new TVShow();
		readerloop: while (reader.hasNext()) {
			switch (reader.next()) {
			case XMLStreamConstants.START_ELEMENT:
				parseTag(reader, tvshow);
				break;
			case XMLStreamConstants.END_ELEMENT:
				if (SERIES.equals(reader.getLocalName().toLowerCase())) {
					break readerloop;
				}
			default:
				break;
			}
		}
		return tvshow;
	}

	private void parseTag(XMLStreamReader reader, TVShow tvshow)
			throws XMLStreamException {
		String tag = reader.getLocalName().toLowerCase();
		switch (tag) {
		case SERIESID:
			tvshow.setId(getContent(reader));
			break;
		case LANGUAGE:
			tvshow.setLang(getContent(reader));
			break;
		case SERIESNAME:
			tvshow.setName(getContent(reader));
			break;
		default:
			break;
		}
	}

	private String getContent(XMLStreamReader reader) throws XMLStreamException {
		if (reader.next() == XMLStreamReader.CHARACTERS) {
			return reader.getText();
		}
		logger.warn("failed to find content while parsing tag");
		return null;
	}
}
