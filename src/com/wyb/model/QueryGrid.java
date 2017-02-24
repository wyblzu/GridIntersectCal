package com.wyb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wyb on 2017/2/24.
 */
@Entity
public class QueryGrid {

    private String id;
    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String geokey;

    @Column(name = "geokey")
    public String getGeokey() {
        return geokey;
    }

    public void setGeokey(String geokey) {
        this.geokey = geokey;
    }

    private String name;

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
