package org.beacon.tvdbapi;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Get a list of TVshows matching a search term from The TVDB.
 * TVDB returns a XML document with all matching shows.
 * The XML is parsed with a SAXparser.
 * The TVDB xmlformat:
 * <Data>
 *  <Series>
 *      <seriesid></seriesid>
 *      <language></language>
 *      <SeriesName></SeriesName>
 *      <Overview></Overview>
 *      <FirstAired></FirstAired>
 *      <Network></Network>
 *      <id></id>
 *  </Series>
 * </Data>
 */

public class TVShowSearchParser {

    private SAXParser saxParser;
    private Handler handler;
    private static final String apiUrl = "http://www.thetvdb.com/api/GetSeries.php?seriesname=";

    public TVShowSearchParser() throws ParserConfigurationException, SAXException
    {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        this.saxParser = factory.newSAXParser();
        this.handler = new Handler(this.saxParser.getXMLReader());
        
    }

    public ArrayList<TVShow> search(String tvShowName) throws SAXException, IOException
    {
        URL url = new URL(apiUrl + tvShowName);
        InputSource in = new InputSource(url.openStream());
        this.saxParser.parse(in, this.handler);
        return this.handler.getMatchingTVShows();
    }

    /**
     * SAXHandler to find <Serie> and initiate SeriesHandler on the child nodes
     */
    private class Handler extends DefaultHandler
    {
        XMLReader reader;
        private ArrayList<TVShow> matchingTVShows = new ArrayList<>();
        public Handler(XMLReader reader)
        {
            this.reader = reader;
        }
        
        public ArrayList<TVShow> getMatchingTVShows()
        {
            return this.matchingTVShows;
        }
        
        public void startElement(String uri, String localName,String qName, 
                Attributes attributes) throws SAXException
        {
 
            if (qName.equalsIgnoreCase("Series")) {
                this.reader.setContentHandler(new SeriesHandler(this.reader, this));
            }
        }

        public void addTVShow(TVShow tvShow) {
            this.matchingTVShows.add(tvShow);
        }
    }
    
    /**
     * SAXHandler to parse and extract information from children of <Serie>
     */
    private class SeriesHandler extends DefaultHandler
    {
        private XMLReader reader;
        private Handler parentHandler;
        private StringBuilder content;
        private TVShow tvShow;

        public SeriesHandler(XMLReader reader, Handler parentHandler)
        {
            this.reader = reader;
            this.parentHandler = parentHandler;
            this.content = new StringBuilder();
            this.tvShow = new TVShow();
        }

        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
            this.content.setLength(0);
        }

        public void endElement(String uri, String localName,String qName)
                throws SAXException
        {
            if (qName.equalsIgnoreCase("seriesid")) {
                this.tvShow.setId(this.content.toString());
            }
            else if(qName.equalsIgnoreCase("language"))
            {
                this.tvShow.setLang(this.content.toString());
            }
            else if(qName.equalsIgnoreCase("SeriesName"))
            {
                this.tvShow.setName(this.content.toString());
            }
            else if(qName.equalsIgnoreCase("Series"))
            {
                this.parentHandler.addTVShow(this.tvShow);
                this.reader.setContentHandler(this.parentHandler);
            }
        }

        public void characters(char ch[], int start, int length)
                throws SAXException {
            this.content.append(ch, start, length);
        }
    }
}
