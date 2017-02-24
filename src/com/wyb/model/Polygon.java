package com.wyb.model;

import javax.persistence.*;

/**
 * Created by wyb on 2017/2/23.
 */
@Entity
@Table(name = "zd_ring")
public class Polygon {
    private Long id;
    private String name;
    private String wktString;



    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;

    }
    public void setId(Long id) {
        this.id = id;
    }
    @Column(name = "wktString")
    public String getWktString() {
        return wktString;
    }

    public void setWktString(String wktString) {
        this.wktString = wktString;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
