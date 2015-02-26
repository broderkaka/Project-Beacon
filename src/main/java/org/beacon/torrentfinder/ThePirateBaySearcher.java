package org.beacon.torrentfinder;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;
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
	

	
	final static Logger logger = LoggerFactory.getLogger(TVShowSearcher.class);

	private static final String TR = "tr";
	private static final String DIV = "div";
	private static final String CLASS = "class";
	private static final String DETNAME = "detName";
	private static final String A = "a";
	private static final String HREF = "href";
	private static final String TD = "td";
	private static final String ALIGN = "right";
	private static final String RIGHT = "right";

	
	
	public ThePirateBaySearcher() {
		factory = XMLInputFactory.newInstance();
		factory.setProperty(XMLInputFactory.IS_COALESCING, true);
	}
	
    public ArrayList<Torrent> findTorrents(TVShow tvshow, Episode episode) throws XMLStreamException, IOException
    {
    	String searchString = buildSearchString(tvshow, episode);
    	String searchURL = String.format("%s", TPBURL, searchString, TPBURLSUFFIX);
    	URL url = new URL(searchURL);
    	HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
    	InputStream s = con.getInputStream();
		XMLStreamReader reader = factory
				.createXMLStreamReader(s);
		
		return findTR(reader);
		
    }

	private ArrayList<Torrent> findTR(XMLStreamReader reader) throws XMLStreamException {
		ArrayList<Torrent> torrents = new ArrayList<>();
		while (reader.hasNext()) {
			if (reader.next() == XMLStreamConstants.START_ELEMENT) {
				if (TR.equals(reader.getLocalName().toLowerCase())) {
					Torrent torrent = parseTR(reader);
					if (torrent.hasValues())
					{
						torrents.add(torrent);
					}
				}
			}
		}
		return torrents;
	}

	private Torrent parseTR(XMLStreamReader reader) throws XMLStreamException {
		Torrent torrent = new Torrent();
		while (reader.hasNext()) {
			int event = reader.next();
			String name = reader.getLocalName().toLowerCase();
			if (TR.equals(name))
			{
				if (event == XMLStreamConstants.START_ELEMENT)
				{
					parseTag(reader, torrent);
				}
				else
				{
					break;
				}
				
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
		case A:
			torrent.setMagnetLink(parseOuterA(reader));
			break;
		case TD:
			parseTD(reader, torrent);
			break;
		default:
			break;
		}
		
			
		
	}



	private void parseTD(XMLStreamReader reader, Torrent torrent) throws XMLStreamException {
		if (!ALIGN.equals(reader.getAttributeLocalName(0)))
		{
			return;
		}
		if (!RIGHT.equals(reader.getAttributeValue(0)))
		{
			return;
		}
		if (torrent.getSeeders() == null)
		{
			torrent.setSeeders(getContent(reader));
		}
		else
		{
			torrent.setLeechers(getContent(reader));
		}
	}

	private String parseOuterA(XMLStreamReader reader) {
		if (HREF.equals(reader.getAttributeLocalName(0)))
		{
			return reader.getAttributeValue(0);
		}
		return null;
		
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

	private void parseA(XMLStreamReader reader, Torrent torrent) throws XMLStreamException {
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