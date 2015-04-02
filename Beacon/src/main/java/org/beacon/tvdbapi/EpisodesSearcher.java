package org.beacon.tvdbapi;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Fetch all episodes from The TVDB tvshows. TVDB returns a zip file with three
 * XML document %lang".xml contains all episodes. The XML is parsed with a
 * SAXparser. See The TVDB wiki for XML reference.
 */
public class EpisodesSearcher {

	private static final String SEASONID = "seasonid";
	private static final String LASTUPDATED = "lastupdated";
	private static final String SEASONNUMBER = "seasonnumber";
	private static final String LANGUAGE = "language";
	private static final String FIRSTAIRED = "firstaired";
	private static final String EPISODENUMBER = "episodenumber";
	private static final String EPISODENAME = "episodename";
	private static final String ID = "id";
	private static final String EPISODE = "episode";

	final static Logger logger = LoggerFactory
			.getLogger(EpisodesSearcher.class);

	private static final String APIURL = "http://www.thetvdb.com/api/%s/series/%s/all/%s.zip";
	private static final String LANG = "en";
	private static final String APIKEY = "040D2018CD1FCCD2";

	private XMLInputFactory factory;

	public EpisodesSearcher() {
		factory = XMLInputFactory.newInstance();
	}

	public TVShow loadEpisodes(TVShow tvShow)
			throws XMLStreamException, IOException {
		URL url = new URL(String.format(APIURL, APIKEY, tvShow.getId(), LANG));

		InputStream in = url.openStream();
		ZipInputStream zipStream = findXMLinZip(in);
		if (zipStream != null) {
			XMLStreamReader reader = factory.createXMLStreamReader(zipStream);
			return parse(reader, tvShow);
		}
		logger.warn(String.format(
				"%s.xml was not found when searched for TVShow with id: %s",
				EpisodesSearcher.LANG, tvShow.getId()));
		return tvShow;
	}

	private ZipInputStream findXMLinZip(InputStream in) throws IOException {
		ZipInputStream zipStream = new ZipInputStream(in);
		ZipEntry entry;
		while ((entry = zipStream.getNextEntry()) != null) {
			if (entry.getName()
					.equalsIgnoreCase(EpisodesSearcher.LANG + ".xml")) {
				return zipStream;
			}
		}
		return null;
	}

	private TVShow parse(XMLStreamReader reader, TVShow tvShow)
			throws XMLStreamException {
		while (reader.hasNext()) {
			if (reader.next() == XMLStreamConstants.START_ELEMENT) {
				if (EPISODE.equals(reader.getLocalName().toLowerCase())) {
                    Episode episode = parseEpisode(reader);
                    tvShow.addEpisode(episode);

				}
			}
		}
		return tvShow;
	}

	private Episode parseEpisode(XMLStreamReader reader)
			throws XMLStreamException {
		Episode episode = new Episode();
		readerloop: while (reader.hasNext()) {
			switch (reader.next()) {
			case XMLStreamConstants.START_ELEMENT:
				parseTag(reader, episode);
				break;
			case XMLStreamConstants.END_ELEMENT:
				if (EPISODE.equals(reader.getLocalName().toLowerCase())) {
					break readerloop;
				}
			default:
				break;
			}
		}
		return episode;
	}

	private void parseTag(XMLStreamReader reader, Episode episode)
			throws XMLStreamException {
		String tag = reader.getLocalName().toLowerCase();
		switch (tag) {
		case ID:
			episode.setId(getContent(reader));
			break;
		case EPISODENAME:
			episode.setEpisodeName(getContent(reader));
			break;
		case EPISODENUMBER:
			episode.setEpisodeNumber(getContent(reader));
			break;
		case FIRSTAIRED:
			episode.setFirstAired(getContent(reader));
			break;
		case LANGUAGE:
			episode.setLanguage(getContent(reader));
			break;
		case SEASONNUMBER:
			episode.setSeasonNumber(getContent(reader));
			break;
		case LASTUPDATED:
			episode.setLastUpdated(getContent(reader));
			break;
		case SEASONID:
			episode.setSeasonID(getContent(reader));
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
