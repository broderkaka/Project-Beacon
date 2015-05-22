package org.beacon.tvdb.gen.getSerie;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the org.beacon.tvdb.gen.getSerie package.
 * <p>An FullSerieFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class FullSerieFactory {


    /**
     * Create a new FullSerieFactory that can be used to create new instances of schema derived classes for package: org.beacon.tvdb.gen.getSerie
     */
    public FullSerieFactory() {
    }

    /**
     * Create an instance of {@link FullSerie }
     */
    public FullSerie createData() {
        return new FullSerie();
    }

    /**
     * Create an instance of {@link FullSerie.Series }
     */
    public FullSerie.Series createDataSeries() {
        return new FullSerie.Series();
    }

    /**
     * Create an instance of {@link FullSerie.Episode }
     */
    public FullSerie.Episode createDataEpisode() {
        return new FullSerie.Episode();
    }

}
