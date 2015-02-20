package org.beacon.tvdbapi;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Get a list of TVshows matching a search term from The TVDB. TVDB returns a
 * XML document with all matching shows. The XML is parsed with a SAXparser. The
 * See The TVDB wiki for XML reference.
 */

public class TVShowSearcher {

	private SAXParser saxParser;
	private SeriesHandler handler;
	private static final String apiUrl = "http://www.thetvdb.com/api/GetSeries.php?seriesname=";

	public TVShowSearcher() throws ParserConfigurationException, SAXException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		this.saxParser = factory.newSAXParser();
		this.handler = new SeriesHandler(this.saxParser.getXMLReader());

	}

	public ArrayList<TVShow> search(String tvShowName) throws SAXException,
			IOException {
		URL url = new URL(apiUrl + tvShowName);
		InputSource in = new InputSource(url.openStream());
		this.saxParser.parse(in, this.handler);
		return this.handler.getMatchingTVShows();
	}
}
