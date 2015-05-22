package org.beacon.tvdb;

import org.beacon.tvdb.gen.banners.Banners;
import org.beacon.tvdb.gen.getSerie.FullSerie;
import org.beacon.tvdb.gen.searchSeries.SeriesList;
import org.beacon.tvshow.TVShowTemplate;
import org.beacon.tvshow.TVShowTemplateList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class TVDBapi {

    public static final String MIRROR_PATH = "http://www.thetvdb.com/";
    public static final String SEARCH_SERIES_PATH = MIRROR_PATH + "api/GetSeries.php?seriesname=";
    public static final String BANNERS = "banners";
    final static Logger logger = LoggerFactory.getLogger(TVDBapi.class);
    private static final String APIURL = MIRROR_PATH + "api/%s/series/%s/all/%s.zip";
    private static final String LANG = "en";
    private static final String APIKEY = "040D2018CD1FCCD2";

    public TVShowTemplateList searchTVShows(String tvShowName) {
        JAXBElement<SeriesList> series = null;
        String query = SEARCH_SERIES_PATH + tvShowName;
        try {
            JAXBContext jc = JAXBContext.newInstance("org.beacon.tvdb.gen.searchSeries");
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            URL url = new URL(query);
            InputStream xml = url.openStream();
            series = unmarshaller.unmarshal(new StreamSource(xml), SeriesList.class);
            xml.close();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (series == null) {
            logger.debug("Found no matches for query: " + query);
            return TVShowTemplateList.EMPTY;
        }
        return TVShowTemplateList.fromSeriesList(series.getValue());
    }


    public FullSerie getTemplate(TVShowTemplate template) {
        String query = String.format(APIURL, APIKEY, template.getId(), LANG);
        FullSerie serie = null;
        Banners banners = null;

        try {
            URL url = new URL(query);
            InputStream in = url.openStream();
            ZipInputStream zipStream = new ZipInputStream(in);
            ZipEntry entry;
            while ((entry = zipStream.getNextEntry()) != null) {
                if (entry.getName()
                        .equalsIgnoreCase(LANG + ".xml")) {
                    serie = getFullSeries(zipStream);
                }
                if (entry.getName()
                        .equalsIgnoreCase(BANNERS + ".xml")) {
                    banners = getBanners(zipStream);
                }
            }
            in.close();
            zipStream.close();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (serie == null) {
            logger.debug("Found no matches for query: " + query);
            return null;
        }
        if (banners == null) {
            logger.debug("Found no banners for query: " + query);
        }
        serie.setBanners(banners);
        return serie;
    }

    private Banners getBanners(ZipInputStream zipStream) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance("org.beacon.tvdb.gen.banners");
        Unmarshaller unmarshaller = jc.createUnmarshaller();

        JAXBElement<Banners> banners = unmarshaller.unmarshal(new StreamSource(zipStream), Banners.class);
        return banners.getValue();
    }

    private FullSerie getFullSeries(ZipInputStream zipStream) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance("org.beacon.tvdb.gen.getserie");
        Unmarshaller unmarshaller = jc.createUnmarshaller();

        JAXBElement<FullSerie> series = unmarshaller.unmarshal(new StreamSource(zipStream), FullSerie.class);
        return series.getValue();
    }
}