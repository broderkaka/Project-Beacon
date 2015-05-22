package org.beacon.tvdb.gen.searchSeries;


import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Series" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="seriesid" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                   &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="SeriesName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Overview" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="banner" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FirstAired" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="Network" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                   &lt;element name="zap2it_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="IMDB_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="AliasNames" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "series"
})
@XmlRootElement(name = "FullSerie")
public class SeriesList {

    @XmlElement(name = "Series")
    protected List<SeriesList.Series> series;

    /**
     * Gets the value of the series property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the series property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    searchSeries().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link SeriesList.Series }
     */
    public List<SeriesList.Series> getSeries() {
        if (series == null) {
            series = new ArrayList<SeriesList.Series>();
        }
        return this.series;
    }


    /**
     * <p>Java class for anonymous complex type.
     * <p/>
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p/>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="seriesid" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *         &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="SeriesName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Overview" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="banner" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FirstAired" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="Network" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *         &lt;element name="zap2it_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="IMDB_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="AliasNames" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "seriesid",
            "language",
            "seriesName",
            "overview",
            "banner",
            "firstAired",
            "network",
            "id",
            "zap2ItId",
            "imdbid",
            "aliasNames"
    })
    public static class Series {

        protected Integer seriesid;

        protected String language;
        @XmlElement(name = "SeriesName")

        protected String seriesName;
        @XmlElement(name = "Overview")

        protected String overview;

        protected String banner;
        @XmlElement(name = "FirstAired")
        @XmlSchemaType(name = "date")

        protected XMLGregorianCalendar firstAired;
        @XmlElement(name = "Network")

        protected String network;

        protected Integer id;
        @XmlElement(name = "zap2it_id")

        protected String zap2ItId;
        @XmlElement(name = "IMDB_ID")

        protected String imdbid;
        @XmlElement(name = "AliasNames")

        protected String aliasNames;

        /**
         * Gets the value of the seriesid property.
         *
         * @return possible object is
         * {@link Integer }
         */
        public Integer getSeriesid() {
            return seriesid;
        }

        /**
         * Sets the value of the seriesid property.
         *
         * @param value allowed object is
         *              {@link Integer }
         */
        public void setSeriesid(Integer value) {
            this.seriesid = value;
        }

        /**
         * Gets the value of the language property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getLanguage() {
            return language;
        }

        /**
         * Sets the value of the language property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setLanguage(String value) {
            this.language = value;
        }

        /**
         * Gets the value of the seriesName property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getSeriesName() {
            return seriesName;
        }

        /**
         * Sets the value of the seriesName property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setSeriesName(String value) {
            this.seriesName = value;
        }

        /**
         * Gets the value of the overview property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getOverview() {
            return overview;
        }

        /**
         * Sets the value of the overview property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setOverview(String value) {
            this.overview = value;
        }

        /**
         * Gets the value of the banner property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getBanner() {
            return banner;
        }

        /**
         * Sets the value of the banner property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setBanner(String value) {
            this.banner = value;
        }

        /**
         * Gets the value of the firstAired property.
         *
         * @return possible object is
         * {@link XMLGregorianCalendar }
         */
        public XMLGregorianCalendar getFirstAired() {
            return firstAired;
        }

        /**
         * Sets the value of the firstAired property.
         *
         * @param value allowed object is
         *              {@link XMLGregorianCalendar }
         */
        public void setFirstAired(XMLGregorianCalendar value) {
            this.firstAired = value;
        }

        /**
         * Gets the value of the network property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getNetwork() {
            return network;
        }

        /**
         * Sets the value of the network property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setNetwork(String value) {
            this.network = value;
        }

        /**
         * Gets the value of the id property.
         *
         * @return possible object is
         * {@link Integer }
         */
        public Integer getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         *
         * @param value allowed object is
         *              {@link Integer }
         */
        public void setId(Integer value) {
            this.id = value;
        }

        /**
         * Gets the value of the zap2ItId property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getZap2ItId() {
            return zap2ItId;
        }

        /**
         * Sets the value of the zap2ItId property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setZap2ItId(String value) {
            this.zap2ItId = value;
        }

        /**
         * Gets the value of the imdbid property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getIMDBID() {
            return imdbid;
        }

        /**
         * Sets the value of the imdbid property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setIMDBID(String value) {
            this.imdbid = value;
        }

        /**
         * Gets the value of the aliasNames property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getAliasNames() {
            return aliasNames;
        }

        /**
         * Sets the value of the aliasNames property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setAliasNames(String value) {
            this.aliasNames = value;
        }

    }

}
