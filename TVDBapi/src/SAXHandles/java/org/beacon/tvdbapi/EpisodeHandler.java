package org.beacon.tvdbapi;

import java.util.ArrayList;

import org.beacon.tvdbapi.Episode;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class EpisodeHandler extends DefaultHandler {

    private XMLReader reader;
    private ArrayList<Episode> episodes;

    public EpisodeHandler(XMLReader reader) {
        this.reader = reader;
        this.episodes = new ArrayList<>();
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("Episode"))
        {
            this.reader.setContentHandler(new ChildHandler(this.reader, this));
        }
    }

    public void addEpisode(Episode episode) {
        this.episodes.add(episode);
    }

    public ArrayList<Episode> getEpisodes() {
        return this.episodes;
    }

    private class ChildHandler extends DefaultHandler {

        private EpisodeHandler parentHandler;
        private StringBuilder content;
        private Episode episode;

        public ChildHandler(XMLReader reader, EpisodeHandler parentHandler) {
            this.parentHandler = parentHandler;
            this.content = new StringBuilder();
            this.episode = new Episode();
        }

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            this.content.setLength(0);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("id"))
            {
                this.episode.setId(this.content.toString());
            } else if (qName.equalsIgnoreCase("EpisodeName"))
            {
                this.episode.setEpisodeName(this.content.toString());
            } else if (qName.equalsIgnoreCase("EpisodeNumber"))
            {
                this.episode.setEpisodeNumber(this.content.toString());
            } else if (qName.equalsIgnoreCase("FirstAired"))
            {
                this.episode.setFirstAired(this.content.toString());
            } else if (qName.equalsIgnoreCase("Language"))
            {
                this.episode.setLanguage(this.content.toString());
            } else if (qName.equalsIgnoreCase("SeasonNumber"))
            {
                this.episode.setSeasonNumber(this.content.toString());
            } else if (qName.equalsIgnoreCase("lastupdated"))
            {
                this.episode.setLastupdated(this.content.toString());
            } else if (qName.equalsIgnoreCase("seasonid"))
            {
                this.episode.setSeasonid(this.content.toString());
            } else if (qName.equalsIgnoreCase("Episode"))
            {
                this.parentHandler.addEpisode(this.episode);
                EpisodeHandler.this.reader.setContentHandler(this.parentHandler);
            }
        }

        public void characters(char ch[], int start, int length) throws SAXException {
            this.content.append(ch, start, length);
        }
    }
}
