package org.beacon.tvdbapi;

import java.util.ArrayList;

import org.beacon.tvdbapi.TVShow;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/**
 * SAXHandler to find <Serie> and initiate SeriesHandler on the child nodes
 */
public class SeriesHandler extends DefaultHandler {

    private XMLReader reader;
    private ArrayList<TVShow> matchingTVShows = new ArrayList<>();

    public SeriesHandler(XMLReader reader) {
        this.reader = reader;
    }

    public ArrayList<TVShow> getMatchingTVShows() {
        return this.matchingTVShows;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("Series"))
        {
            this.reader.setContentHandler(new ChildHandler(this.reader, this));
        }
    }

    public void addTVShow(TVShow tvShow) {
        this.matchingTVShows.add(tvShow);
    }

    /**
     * SAXHandler to parse and extract information from children of <Serie>
     */
    private class ChildHandler extends DefaultHandler {

        private SeriesHandler parentHandler;
        private StringBuilder content;
        private TVShow tvShow;

        public ChildHandler(XMLReader reader, SeriesHandler parentHandler) {
            this.parentHandler = parentHandler;
            this.content = new StringBuilder();
            this.tvShow = new TVShow();
        }

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            this.content.setLength(0);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("seriesid"))
            {
                this.tvShow.setId(this.content.toString());
            } else if (qName.equalsIgnoreCase("language"))
            {
                this.tvShow.setLang(this.content.toString());
            } else if (qName.equalsIgnoreCase("SeriesName"))
            {
                this.tvShow.setName(this.content.toString());
            } else if (qName.equalsIgnoreCase("Series"))
            {
                this.parentHandler.addTVShow(this.tvShow);
                SeriesHandler.this.reader.setContentHandler(this.parentHandler);
            }
        }

        public void characters(char ch[], int start, int length) throws SAXException {
            this.content.append(ch, start, length);
        }
    }
}
