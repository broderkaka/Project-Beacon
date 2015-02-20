package org.beacon.tvdbapi;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * Fetch all episodes from The TVDB tvshows. TVDB returns a zip file with three
 * XML document %lang".xml contains all episodes. The XML is parsed with a
 * SAXparser. See The TVDB wiki for XML reference.
 */
public class EpisodesSearcher {

    final static Logger logger = Logger.getLogger(EpisodesSearcher.class);

    private SAXParser saxParser;
    private EpisodeHandler handler;
    private final String apiurl = "http://www.thetvdb.com/api/%s/series/%s/all/%s.zip";
    private final String lang = "en";
    private final String apiKey = "040D2018CD1FCCD2";

    public EpisodesSearcher() throws ParserConfigurationException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        this.saxParser = factory.newSAXParser();
        this.handler = new EpisodeHandler(this.saxParser.getXMLReader());
    }

    public ArrayList<Episode> loadEpisodes(String tvShowId) throws IOException, SAXException {
        URL url = new URL(String.format(this.apiurl, this.apiKey, tvShowId, this.lang));

        InputStream in = url.openStream();
        ZipInputStream zipStream = new ZipInputStream(in);
        ZipEntry entry;
        while ((entry = zipStream.getNextEntry()) != null)
        {
            if (entry.getName().equalsIgnoreCase(this.lang + ".xml"))
            {
                this.saxParser.parse(zipStream, this.handler);
                return this.handler.getEpisodes();
            }
        }
        logger.warn(String.format("%s.xml was not found when searched for TVShow with id: %s", this.lang, tvShowId));
        return new ArrayList<>();
    }
}
