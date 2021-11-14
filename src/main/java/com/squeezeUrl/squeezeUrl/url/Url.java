package com.squeezeUrl.squeezeUrl.url;

import javax.persistence.*;

@Entity
@Table
public class Url {
    @Id
    @SequenceGenerator(
            name="url_id_sequence",
            sequenceName="url_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "url_id_sequence"
    )
    private Integer urlId;
    private String url;
    private String short_url;

    public Url() {

    }

    public Url(String url, String short_url) {
        this.url = url;
        this.short_url = short_url;
    }

    public Integer getUrlId() {
        return urlId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShort_url() {
        return short_url;
    }

    public void setShort_url(String short_url) {
        this.short_url = short_url;
    }

    @Override
    public String toString() {
        return "Url{" +
                "urlId='" + urlId + '\'' +
                ", url='" + url + '\'' +
                ", short_url='" + short_url + '\'' +
                '}';
    }
}
