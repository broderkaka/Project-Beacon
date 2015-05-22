package org.beacon.tvdb.gen.banners;

import org.beacon.tvdb.TVDBapi;

import javax.xml.bind.annotation.*;
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
 *         &lt;element name="Banner" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                   &lt;element name="BannerPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="BannerType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="BannerType2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Colors" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Season" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Rating" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *                   &lt;element name="RatingCount" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
 *                   &lt;element name="SeriesName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ThumbnailPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="VignettePath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "banner"
})
@XmlRootElement(name = "Banners")
public class Banners {

    @XmlElement(name = "Banner", required = true)
    protected List<Banners.Banner> banner;

    /**
     * Gets the value of the banner property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the banner property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBanner().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link Banners.Banner }
     */
    public List<Banners.Banner> getBanner() {
        if (banner == null) {
            banner = new ArrayList<Banners.Banner>();
        }
        return this.banner;
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
     *         &lt;element name="BannerPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="BannerType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="BannerType2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Colors" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Season" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Rating" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
     *         &lt;element name="RatingCount" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
     *         &lt;element name="SeriesName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ThumbnailPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="VignettePath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "id",
            "bannerPath",
            "bannerType",
            "bannerType2",
            "colors",
            "language",
            "season",
            "rating",
            "ratingCount",
            "seriesName",
            "thumbnailPath",
            "vignettePath"
    })
    public static class Banner {

        protected Integer id;
        @XmlElement(name = "BannerPath")
        protected String bannerPath;
        @XmlElement(name = "BannerType")
        protected String bannerType;
        @XmlElement(name = "BannerType2")
        protected String bannerType2;
        @XmlElement(name = "Colors")
        protected String colors;
        @XmlElement(name = "Language")
        protected String language;
        @XmlElement(name = "Season")
        protected Integer season;
        @XmlElement(name = "Rating")
        protected Float rating;
        @XmlElement(name = "RatingCount")
        protected Byte ratingCount;
        @XmlElement(name = "SeriesName")
        protected String seriesName;
        @XmlElement(name = "ThumbnailPath")
        protected String thumbnailPath;
        @XmlElement(name = "VignettePath")
        protected String vignettePath;

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
         * Gets the value of the bannerPath property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getBannerPath() {
            return bannerPath;
        }

        /**
         * Sets the value of the bannerPath property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setBannerPath(String value) {
            this.bannerPath = TVDBapi.MIRROR_PATH + value;
        }

        /**
         * Gets the value of the bannerType property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getBannerType() {
            return bannerType;
        }

        /**
         * Sets the value of the bannerType property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setBannerType(String value) {
            this.bannerType = value;
        }

        /**
         * Gets the value of the bannerType2 property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getBannerType2() {
            return bannerType2;
        }

        /**
         * Sets the value of the bannerType2 property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setBannerType2(String value) {
            this.bannerType2 = value;
        }

        /**
         * Gets the value of the colors property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getColors() {
            return colors;
        }

        /**
         * Sets the value of the colors property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setColors(String value) {
            this.colors = value;
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
         * Gets the value of the season property.
         *
         * @return possible object is
         * {@link String }
         */
        public Integer getSeason() {
            return season;
        }

        /**
         * Sets the value of the season property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setSeason(Integer value) {
            this.season = value;
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
         * Gets the value of the thumbnailPath property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getThumbnailPath() {
            return thumbnailPath;
        }

        /**
         * Sets the value of the thumbnailPath property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setThumbnailPath(String value) {
            this.thumbnailPath = value;
        }

        /**
         * Gets the value of the vignettePath property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getVignettePath() {
            return vignettePath;
        }

        /**
         * Sets the value of the vignettePath property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setVignettePath(String value) {
            this.vignettePath = value;
        }

    }

}
