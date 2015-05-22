package org.beacon.tvdb.gen.getSerie;

import org.beacon.tvdb.gen.banners.Banners;

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
 *         &lt;element name="Series">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                   &lt;element name="Actors" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Airs_DayOfWeek" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Airs_Time" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ContentRating" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FirstAired" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="Genre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="IMDB_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Network" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="NetworkID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Overview" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Rating" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *                   &lt;element name="RatingCount" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                   &lt;element name="Runtime" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
 *                   &lt;element name="SeriesID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                   &lt;element name="SeriesName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="added" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="addedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="banner" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="fanart" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="lastupdated" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                   &lt;element name="poster" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="zap2it_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Episode" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                   &lt;element name="Combined_episodenumber" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
 *                   &lt;element name="Combined_season" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
 *                   &lt;element name="DVD_chapter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DVD_discid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DVD_episodenumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DVD_season" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Director" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="EpImgFlag" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
 *                   &lt;element name="EpisodeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="EpisodeNumber" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
 *                   &lt;element name="FirstAired" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="GuestStars" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="IMDB_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Overview" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ProductionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Rating" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *                   &lt;element name="RatingCount" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
 *                   &lt;element name="SeasonNumber" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
 *                   &lt;element name="Writer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="absolute_number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="airsafter_season" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
 *                   &lt;element name="airsbefore_episode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="airsbefore_season" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="filename" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="lastupdated" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                   &lt;element name="seasonid" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                   &lt;element name="seriesid" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                   &lt;element name="thumb_added" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="thumb_height" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                   &lt;element name="thumb_width" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
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
        "series",
        "episode"
})
@XmlRootElement(name = "Data")
public class FullSerie {

    @XmlElement(name = "Series", required = true)
    protected FullSerie.Series series;
    @XmlElement(name = "Episode")
    protected List<FullSerie.Episode> episode;
    private Banners banners;

    public Banners getBanners() {
        return banners;
    }

    public void setBanners(Banners banners) {
        this.banners = banners;
    }


    /**
     * Gets the value of the series property.
     *
     * @return possible object is
     * {@link FullSerie.Series }
     */
    public FullSerie.Series getSeries() {
        return series;
    }

    /**
     * Sets the value of the series property.
     *
     * @param value allowed object is
     *              {@link FullSerie.Series }
     */
    public void setSeries(FullSerie.Series value) {
        this.series = value;
    }

    /**
     * Gets the value of the episode property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the episode property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEpisode().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link FullSerie.Episode }
     */
    public List<FullSerie.Episode> getEpisode() {
        if (episode == null) {
            episode = new ArrayList<FullSerie.Episode>();
        }
        return this.episode;
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
     *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *         &lt;element name="Combined_episodenumber" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
     *         &lt;element name="Combined_season" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
     *         &lt;element name="DVD_chapter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DVD_discid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DVD_episodenumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DVD_season" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Director" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="EpImgFlag" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
     *         &lt;element name="EpisodeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="EpisodeNumber" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
     *         &lt;element name="FirstAired" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="GuestStars" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="IMDB_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Overview" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ProductionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Rating" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
     *         &lt;element name="RatingCount" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
     *         &lt;element name="SeasonNumber" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
     *         &lt;element name="Writer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="absolute_number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="airsafter_season" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
     *         &lt;element name="airsbefore_episode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="airsbefore_season" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="filename" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="lastupdated" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *         &lt;element name="seasonid" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *         &lt;element name="seriesid" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *         &lt;element name="thumb_added" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="thumb_height" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *         &lt;element name="thumb_width" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "id",
            "combinedEpisodenumber",
            "combinedSeason",
            "dvdChapter",
            "dvdDiscid",
            "dvdEpisodenumber",
            "dvdSeason",
            "director",
            "epImgFlag",
            "episodeName",
            "episodeNumber",
            "firstAired",
            "guestStars",
            "imdbid",
            "language",
            "overview",
            "productionCode",
            "rating",
            "ratingCount",
            "seasonNumber",
            "writer",
            "absoluteNumber",
            "airsafterSeason",
            "airsbeforeEpisode",
            "airsbeforeSeason",
            "filename",
            "lastupdated",
            "seasonid",
            "seriesid",
            "thumbAdded",
            "thumbHeight",
            "thumbWidth"
    })
    public static class Episode {

        protected Integer id;
        @XmlElement(name = "Combined_episodenumber")
        protected Byte combinedEpisodenumber;
        @XmlElement(name = "Combined_season")
        protected Byte combinedSeason;
        @XmlElement(name = "DVD_chapter")
        protected String dvdChapter;
        @XmlElement(name = "DVD_discid")
        protected String dvdDiscid;
        @XmlElement(name = "DVD_episodenumber")
        protected String dvdEpisodenumber;
        @XmlElement(name = "DVD_season")
        protected String dvdSeason;
        @XmlElement(name = "Director")
        protected String director;
        @XmlElement(name = "EpImgFlag")
        protected Byte epImgFlag;
        @XmlElement(name = "EpisodeName")
        protected String episodeName;
        @XmlElement(name = "EpisodeNumber")
        protected Byte episodeNumber;
        @XmlElement(name = "FirstAired")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar firstAired;
        @XmlElement(name = "GuestStars")
        protected String guestStars;
        @XmlElement(name = "IMDB_ID")
        protected String imdbid;
        @XmlElement(name = "Language")
        protected String language;
        @XmlElement(name = "Overview")
        protected String overview;
        @XmlElement(name = "ProductionCode")
        protected String productionCode;
        @XmlElement(name = "Rating")
        protected Float rating;
        @XmlElement(name = "RatingCount")
        protected Byte ratingCount;
        @XmlElement(name = "SeasonNumber")
        protected Byte seasonNumber;
        @XmlElement(name = "Writer")
        protected String writer;
        @XmlElement(name = "absolute_number")
        protected String absoluteNumber;
        @XmlElement(name = "airsafter_season")
        protected Byte airsafterSeason;
        @XmlElement(name = "airsbefore_episode")
        protected String airsbeforeEpisode;
        @XmlElement(name = "airsbefore_season")
        protected String airsbeforeSeason;
        protected String filename;
        protected Integer lastupdated;
        protected Short seasonid;
        protected Integer seriesid;
        @XmlElement(name = "thumb_added")
        protected String thumbAdded;
        @XmlElement(name = "thumb_height")
        protected Short thumbHeight;
        @XmlElement(name = "thumb_width")
        protected Short thumbWidth;


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
         * Gets the value of the combinedEpisodenumber property.
         *
         * @return possible object is
         * {@link Byte }
         */
        public Byte getCombinedEpisodenumber() {
            return combinedEpisodenumber;
        }

        /**
         * Sets the value of the combinedEpisodenumber property.
         *
         * @param value allowed object is
         *              {@link Byte }
         */
        public void setCombinedEpisodenumber(Byte value) {
            this.combinedEpisodenumber = value;
        }

        /**
         * Gets the value of the combinedSeason property.
         *
         * @return possible object is
         * {@link Byte }
         */
        public Byte getCombinedSeason() {
            return combinedSeason;
        }

        /**
         * Sets the value of the combinedSeason property.
         *
         * @param value allowed object is
         *              {@link Byte }
         */
        public void setCombinedSeason(Byte value) {
            this.combinedSeason = value;
        }

        /**
         * Gets the value of the dvdChapter property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getDVDChapter() {
            return dvdChapter;
        }

        /**
         * Sets the value of the dvdChapter property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setDVDChapter(String value) {
            this.dvdChapter = value;
        }

        /**
         * Gets the value of the dvdDiscid property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getDVDDiscid() {
            return dvdDiscid;
        }

        /**
         * Sets the value of the dvdDiscid property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setDVDDiscid(String value) {
            this.dvdDiscid = value;
        }

        /**
         * Gets the value of the dvdEpisodenumber property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getDVDEpisodenumber() {
            return dvdEpisodenumber;
        }

        /**
         * Sets the value of the dvdEpisodenumber property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setDVDEpisodenumber(String value) {
            this.dvdEpisodenumber = value;
        }

        /**
         * Gets the value of the dvdSeason property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getDVDSeason() {
            return dvdSeason;
        }

        /**
         * Sets the value of the dvdSeason property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setDVDSeason(String value) {
            this.dvdSeason = value;
        }

        /**
         * Gets the value of the director property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getDirector() {
            return director;
        }

        /**
         * Sets the value of the director property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setDirector(String value) {
            this.director = value;
        }

        /**
         * Gets the value of the epImgFlag property.
         *
         * @return possible object is
         * {@link Byte }
         */
        public Byte getEpImgFlag() {
            return epImgFlag;
        }

        /**
         * Sets the value of the epImgFlag property.
         *
         * @param value allowed object is
         *              {@link Byte }
         */
        public void setEpImgFlag(Byte value) {
            this.epImgFlag = value;
        }

        /**
         * Gets the value of the episodeName property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getEpisodeName() {
            return episodeName;
        }

        /**
         * Sets the value of the episodeName property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setEpisodeName(String value) {
            this.episodeName = value;
        }

        /**
         * Gets the value of the episodeNumber property.
         *
         * @return possible object is
         * {@link Byte }
         */
        public Byte getEpisodeNumber() {
            return episodeNumber;
        }

        /**
         * Sets the value of the episodeNumber property.
         *
         * @param value allowed object is
         *              {@link Byte }
         */
        public void setEpisodeNumber(Byte value) {
            this.episodeNumber = value;
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
         * Gets the value of the guestStars property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getGuestStars() {
            return guestStars;
        }

        /**
         * Sets the value of the guestStars property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setGuestStars(String value) {
            this.guestStars = value;
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
         * Gets the value of the productionCode property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getProductionCode() {
            return productionCode;
        }

        /**
         * Sets the value of the productionCode property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setProductionCode(String value) {
            this.productionCode = value;
        }

        /**
         * Gets the value of the rating property.
         *
         * @return possible object is
         * {@link Float }
         */
        public Float getRating() {
            return rating;
        }

        /**
         * Sets the value of the rating property.
         *
         * @param value allowed object is
         *              {@link Float }
         */
        public void setRating(Float value) {
            this.rating = value;
        }

        /**
         * Gets the value of the ratingCount property.
         *
         * @return possible object is
         * {@link Byte }
         */
        public Byte getRatingCount() {
            return ratingCount;
        }

        /**
         * Sets the value of the ratingCount property.
         *
         * @param value allowed object is
         *              {@link Byte }
         */
        public void setRatingCount(Byte value) {
            this.ratingCount = value;
        }

        /**
         * Gets the value of the seasonNumber property.
         *
         * @return possible object is
         * {@link Byte }
         */
        public Byte getSeasonNumber() {
            return seasonNumber;
        }

        /**
         * Sets the value of the seasonNumber property.
         *
         * @param value allowed object is
         *              {@link Byte }
         */
        public void setSeasonNumber(Byte value) {
            this.seasonNumber = value;
        }

        /**
         * Gets the value of the writer property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getWriter() {
            return writer;
        }

        /**
         * Sets the value of the writer property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setWriter(String value) {
            this.writer = value;
        }

        /**
         * Gets the value of the absoluteNumber property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getAbsoluteNumber() {
            return absoluteNumber;
        }

        /**
         * Sets the value of the absoluteNumber property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setAbsoluteNumber(String value) {
            this.absoluteNumber = value;
        }

        /**
         * Gets the value of the airsafterSeason property.
         *
         * @return possible object is
         * {@link Byte }
         */
        public Byte getAirsafterSeason() {
            return airsafterSeason;
        }

        /**
         * Sets the value of the airsafterSeason property.
         *
         * @param value allowed object is
         *              {@link Byte }
         */
        public void setAirsafterSeason(Byte value) {
            this.airsafterSeason = value;
        }

        /**
         * Gets the value of the airsbeforeEpisode property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getAirsbeforeEpisode() {
            return airsbeforeEpisode;
        }

        /**
         * Sets the value of the airsbeforeEpisode property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setAirsbeforeEpisode(String value) {
            this.airsbeforeEpisode = value;
        }

        /**
         * Gets the value of the airsbeforeSeason property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getAirsbeforeSeason() {
            return airsbeforeSeason;
        }

        /**
         * Sets the value of the airsbeforeSeason property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setAirsbeforeSeason(String value) {
            this.airsbeforeSeason = value;
        }

        /**
         * Gets the value of the filename property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getFilename() {
            return filename;
        }

        /**
         * Sets the value of the filename property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setFilename(String value) {
            this.filename = value;
        }

        /**
         * Gets the value of the lastupdated property.
         *
         * @return possible object is
         * {@link Integer }
         */
        public Integer getLastupdated() {
            return lastupdated;
        }

        /**
         * Sets the value of the lastupdated property.
         *
         * @param value allowed object is
         *              {@link Integer }
         */
        public void setLastupdated(Integer value) {
            this.lastupdated = value;
        }

        /**
         * Gets the value of the seasonid property.
         *
         * @return possible object is
         * {@link Short }
         */
        public Short getSeasonid() {
            return seasonid;
        }

        /**
         * Sets the value of the seasonid property.
         *
         * @param value allowed object is
         *              {@link Short }
         */
        public void setSeasonid(Short value) {
            this.seasonid = value;
        }

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
         * Gets the value of the thumbAdded property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getThumbAdded() {
            return thumbAdded;
        }

        /**
         * Sets the value of the thumbAdded property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setThumbAdded(String value) {
            this.thumbAdded = value;
        }

        /**
         * Gets the value of the thumbHeight property.
         *
         * @return possible object is
         * {@link Short }
         */
        public Short getThumbHeight() {
            return thumbHeight;
        }

        /**
         * Sets the value of the thumbHeight property.
         *
         * @param value allowed object is
         *              {@link Short }
         */
        public void setThumbHeight(Short value) {
            this.thumbHeight = value;
        }

        /**
         * Gets the value of the thumbWidth property.
         *
         * @return possible object is
         * {@link Short }
         */
        public Short getThumbWidth() {
            return thumbWidth;
        }

        /**
         * Sets the value of the thumbWidth property.
         *
         * @param value allowed object is
         *              {@link Short }
         */
        public void setThumbWidth(Short value) {
            this.thumbWidth = value;
        }

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
     *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *         &lt;element name="Actors" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Airs_DayOfWeek" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Airs_Time" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ContentRating" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FirstAired" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="Genre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="IMDB_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Network" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="NetworkID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Overview" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Rating" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
     *         &lt;element name="RatingCount" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *         &lt;element name="Runtime" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
     *         &lt;element name="SeriesID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *         &lt;element name="SeriesName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="added" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="addedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="banner" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="fanart" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="lastupdated" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *         &lt;element name="poster" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="zap2it_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "id",
            "actors",
            "airsDayOfWeek",
            "airsTime",
            "contentRating",
            "firstAired",
            "genre",
            "imdbid",
            "language",
            "network",
            "networkID",
            "overview",
            "rating",
            "ratingCount",
            "runtime",
            "seriesID",
            "seriesName",
            "status",
            "added",
            "addedBy",
            "banner",
            "fanart",
            "lastupdated",
            "poster",
            "zap2ItId"
    })
    public static class Series {

        protected Integer id;
        @XmlElement(name = "Actors")
        protected String actors;
        @XmlElement(name = "Airs_DayOfWeek")
        protected String airsDayOfWeek;
        @XmlElement(name = "Airs_Time")
        protected String airsTime;
        @XmlElement(name = "ContentRating")
        protected String contentRating;
        @XmlElement(name = "FirstAired")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar firstAired;
        @XmlElement(name = "Genre")
        protected String genre;
        @XmlElement(name = "IMDB_ID")
        protected String imdbid;
        @XmlElement(name = "Language")
        protected String language;
        @XmlElement(name = "Network")
        protected String network;
        @XmlElement(name = "NetworkID")
        protected String networkID;
        @XmlElement(name = "Overview")
        protected String overview;
        @XmlElement(name = "Rating")
        protected Float rating;
        @XmlElement(name = "RatingCount")
        protected Short ratingCount;
        @XmlElement(name = "Runtime")
        protected Byte runtime;
        @XmlElement(name = "SeriesID")
        protected Integer seriesID;
        @XmlElement(name = "SeriesName")
        protected String seriesName;
        @XmlElement(name = "Status")
        protected String status;
        protected String added;
        protected String addedBy;
        protected String banner;
        protected String fanart;
        protected Integer lastupdated;
        protected String poster;
        @XmlElement(name = "zap2it_id")
        protected String zap2ItId;

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
         * Gets the value of the actors property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getActors() {
            return actors;
        }

        /**
         * Sets the value of the actors property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setActors(String value) {
            this.actors = value;
        }

        /**
         * Gets the value of the airsDayOfWeek property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getAirsDayOfWeek() {
            return airsDayOfWeek;
        }

        /**
         * Sets the value of the airsDayOfWeek property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setAirsDayOfWeek(String value) {
            this.airsDayOfWeek = value;
        }

        /**
         * Gets the value of the airsTime property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getAirsTime() {
            return airsTime;
        }

        /**
         * Sets the value of the airsTime property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setAirsTime(String value) {
            this.airsTime = value;
        }

        /**
         * Gets the value of the contentRating property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getContentRating() {
            return contentRating;
        }

        /**
         * Sets the value of the contentRating property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setContentRating(String value) {
            this.contentRating = value;
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
         * Gets the value of the genre property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getGenre() {
            return genre;
        }

        /**
         * Sets the value of the genre property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setGenre(String value) {
            this.genre = value;
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
         * Gets the value of the networkID property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getNetworkID() {
            return networkID;
        }

        /**
         * Sets the value of the networkID property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setNetworkID(String value) {
            this.networkID = value;
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
         * Gets the value of the rating property.
         *
         * @return possible object is
         * {@link Float }
         */
        public Float getRating() {
            return rating;
        }

        /**
         * Sets the value of the rating property.
         *
         * @param value allowed object is
         *              {@link Float }
         */
        public void setRating(Float value) {
            this.rating = value;
        }

        /**
         * Gets the value of the ratingCount property.
         *
         * @return possible object is
         * {@link Short }
         */
        public Short getRatingCount() {
            return ratingCount;
        }

        /**
         * Sets the value of the ratingCount property.
         *
         * @param value allowed object is
         *              {@link Short }
         */
        public void setRatingCount(Short value) {
            this.ratingCount = value;
        }

        /**
         * Gets the value of the runtime property.
         *
         * @return possible object is
         * {@link Byte }
         */
        public Byte getRuntime() {
            return runtime;
        }

        /**
         * Sets the value of the runtime property.
         *
         * @param value allowed object is
         *              {@link Byte }
         */
        public void setRuntime(Byte value) {
            this.runtime = value;
        }

        /**
         * Gets the value of the seriesID property.
         *
         * @return possible object is
         * {@link Integer }
         */
        public Integer getSeriesID() {
            return seriesID;
        }

        /**
         * Sets the value of the seriesID property.
         *
         * @param value allowed object is
         *              {@link Integer }
         */
        public void setSeriesID(Integer value) {
            this.seriesID = value;
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
         * Gets the value of the status property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getStatus() {
            return status;
        }

        /**
         * Sets the value of the status property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setStatus(String value) {
            this.status = value;
        }

        /**
         * Gets the value of the added property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getAdded() {
            return added;
        }

        /**
         * Sets the value of the added property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setAdded(String value) {
            this.added = value;
        }

        /**
         * Gets the value of the addedBy property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getAddedBy() {
            return addedBy;
        }

        /**
         * Sets the value of the addedBy property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setAddedBy(String value) {
            this.addedBy = value;
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
         * Gets the value of the fanart property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getFanart() {
            return fanart;
        }

        /**
         * Sets the value of the fanart property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setFanart(String value) {
            this.fanart = value;
        }

        /**
         * Gets the value of the lastupdated property.
         *
         * @return possible object is
         * {@link Integer }
         */
        public Integer getLastupdated() {
            return lastupdated;
        }

        /**
         * Sets the value of the lastupdated property.
         *
         * @param value allowed object is
         *              {@link Integer }
         */
        public void setLastupdated(Integer value) {
            this.lastupdated = value;
        }

        /**
         * Gets the value of the poster property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getPoster() {
            return poster;
        }

        /**
         * Sets the value of the poster property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setPoster(String value) {
            this.poster = value;
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

    }

}
