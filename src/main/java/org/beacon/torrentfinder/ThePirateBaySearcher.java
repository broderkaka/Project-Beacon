package org.beacon.torrentfinder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;

import javax.ws.rs.core.UriBuilder;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.beacon.tvdbapi.Episode;
import org.beacon.tvdbapi.TVShow;
import org.beacon.tvdbapi.TVShowSearcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThePirateBaySearcher {
	private XMLInputFactory factory;
	
	private final static String TPBURL = "https://thepiratebay.se/search/";
	private final static String TPBURLSUFFIX = "/0/8/0";
	
	private final String TR = "tr";
	private final String DIV = "div";
	private final String CLASS = "class";
	private final String DETNAME = "detName";
	private final String A = "a";
	
	final static Logger logger = LoggerFactory.getLogger(TVShowSearcher.class);
	
	public ThePirateBaySearcher() {
		factory = XMLInputFactory.newInstance();
		factory.setProperty(XMLInputFactory.IS_COALESCING, true);
	}
	
    public void findTorrents(TVShow tvshow, Episode episode) throws XMLStreamException, IOException
    {
    	String searchString = buildSearchString(tvshow, episode);
    	String searchURL = String.format("%s%s%s", TPBURL, searchString, TPBURLSUFFIX);
    	URL url = new URL(searchURL);
		XMLStreamReader reader = factory
				.createXMLStreamReader(url.openStream());
		
		
		
    }

	private ArrayList<Torrent> findTR(XMLStreamReader reader) throws XMLStreamException {
		ArrayList<Torrent> torrents = new ArrayList<>();
		while (reader.hasNext()) {
			if (reader.next() == XMLStreamConstants.START_ELEMENT) {
				if (TR.equals(reader.getLocalName().toLowerCase())) {
					torrents.add(parseTR(reader));
				}
			}
		}
		return torrents;
	}

	private Torrent parseTR(XMLStreamReader reader) throws XMLStreamException {
		Torrent torrent = new Torrent();
		readerloop: while (reader.hasNext()) {
			switch (reader.next()) {
			case XMLStreamConstants.START_ELEMENT:
				parseTag(reader, torrent);
				break;
			case XMLStreamConstants.END_ELEMENT:
				if (TR.equals(reader.getLocalName().toLowerCase()))
				{
					break readerloop;
				}
				break;
			default:
				break;
			}
		}
		return torrent;
	}

	private void parseTag(XMLStreamReader reader, Torrent torrent) throws XMLStreamException {
		String tag = reader.getLocalName().toLowerCase();
		switch (tag) {
		case DIV:
			parseDIV(reader, torrent);
			break;
		}
		
	}



	private void parseDIV(XMLStreamReader reader, Torrent torrent) throws XMLStreamException {
		if (reader.getAttributeCount() == 0 ||
			!CLASS.equals(reader.getAttributeLocalName(0)) ||
			!DETNAME.equals(reader.getAttributeValue(0)))
		{
			return;
		}
		
		while (reader.hasNext())
		{
			switch (reader.next()) {
			case XMLStreamConstants.START_ELEMENT:
				if (A.equals(reader.getLocalName()))
				{
					parseA(reader, torrent);
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				if (DIV.equals(reader.getLocalName()))
				{
					return;
				}
			default:
				break;
			}
		}
	}

	private void parseA(XMLStreamReader reader, Torrent torrent) {
		torrent.setTitle(getContent(reader));
		
	}
	
	private String getContent(XMLStreamReader reader) throws XMLStreamException {
		if (reader.next() == XMLStreamReader.CHARACTERS) {
			return reader.getText();
		}
		logger.warn("failed to find content while parsing tag");
		return null;
	}

	private String buildSearchString(TVShow tvshow, Episode episode) {
		StringBuilder SearchBulder = new StringBuilder();
    	SearchBulder.append(tvshow.getName());
    	SearchBulder.append(" S");
    	SearchBulder.append(episode.getFormatedSeasonNumber());
    	SearchBulder.append("E");
    	SearchBulder.append(episode.getFormatedEpisodeNumber());
    	String searchString = SearchBulder.toString();
    	//yes this is ugly and we have to fix it, but I cant find a good way to do it
    	searchString = searchString.replace(" ", "%20");
		return searchString;
	}

}