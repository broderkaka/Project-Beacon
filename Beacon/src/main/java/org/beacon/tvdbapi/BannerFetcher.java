package org.beacon.tvdbapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class BannerFetcher {

    final static Logger logger = LoggerFactory
            .getLogger(BannerFetcher.class);

    private static final String APIURL = "http://www.thetvdb.com/api/%s/series/%s/all/%s.zip";
    private static final String APIKEY = "040D2018CD1FCCD2";

    private static final String LANG = "en";
    public static final String BANNERS = "banners";
    public static final String BANNER = "banner";
    public static final String BANNERPATH = "bannerpath";
    public static final String BANNERTYPE = "bannertype";
    public static final String BANNERTYPE2 = "bannertype2";
    public static final String SERIES = "series";
    public static final String SEASON = "season";
    public static final String SEASONWIDE = "seasonwide";
    private XMLInputFactory factory;

    public BannerFetcher() {
        factory = XMLInputFactory.newInstance();
    }

    public void fetchBanner(TVShow tvShow)
            throws XMLStreamException, IOException {
        URL url = new URL(String.format(APIURL, APIKEY, tvShow.getId(), LANG));

        InputStream in = url.openStream();
        ZipInputStream zipStream = findXMLinZip(in);
        if (zipStream != null) {
            XMLStreamReader reader = factory.createXMLStreamReader(zipStream);
            parse(reader, tvShow);
            return;
        }
        logger.warn(String.format(
                "%s.xml was not found when searched for TVShow with id: %s",
                BANNERS, tvShow.getId()));
    }

    private ZipInputStream findXMLinZip(InputStream in) throws IOException {
        ZipInputStream zipStream = new ZipInputStream(in);
        ZipEntry entry;
        while ((entry = zipStream.getNextEntry()) != null) {
            if (entry.getName()
                    .equalsIgnoreCase(BANNERS + ".xml")) {
                return zipStream;
            }
        }
        return null;
    }

    private void parse(XMLStreamReader reader, TVShow tvShow)
            throws XMLStreamException {

        while (reader.hasNext()) {
            if (reader.next() == XMLStreamConstants.START_ELEMENT) {
                if (BANNER.equals(reader.getLocalName().toLowerCase())) {
                    parseBanner(reader, tvShow);
                }
            }
        }
    }

    private String parseBanner(XMLStreamReader reader, TVShow tvShow)
            throws XMLStreamException {
        String bannerPath = null;
        String seasonNumber = null;
        String type = null;
        readerloop: while (reader.hasNext()) {
            int eventtype = reader.next();
            switch (eventtype) {
                case XMLStreamConstants.START_ELEMENT:
                    String tag = reader.getLocalName().toLowerCase();
                    switch (tag) {
                        case BANNERPATH:
                            bannerPath = getContent(reader);
                            break;
                        case BANNERTYPE2:
                            type = getContent(reader);
                            break;
                        case BANNERTYPE:
                            type = getContent(reader);
                            if(SERIES.equalsIgnoreCase(type) && bannerPath != null)
                            {
                                tvShow.addShowBanner(bannerPath);
                                break;
                            }
                            break;
                        case SEASON:
                            seasonNumber = getContent(reader);
                            if(type.equalsIgnoreCase(SEASONWIDE) && seasonNumber != null){
                                tvShow.addSeasonBanner(bannerPath, seasonNumber);
                            }
                        default:
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    if (BANNER.equals(reader.getLocalName().toLowerCase())) {
                        break readerloop;
                    }
                default:
                    break;
            }
        }
        return null;
    }

    private String getContent(XMLStreamReader reader) throws XMLStreamException {
        if (reader.next() == XMLStreamReader.CHARACTERS) {
            return reader.getText();
        }
        logger.warn("failed to find content while parsing tag");
        return null;
    }
}
