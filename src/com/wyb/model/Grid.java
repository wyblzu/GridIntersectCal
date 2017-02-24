package com.wyb.model;

import javax.persistence.*;

/**
 * Created by wyb on 2017/2/23.
 */
@Entity
@Table(name = "quadgrid_18")
public class Grid {
    private Long id;
    private String gridKey;
    private String wktString;
@Id
@GeneratedValue
@Column(name = "id")
    public Long getId(){return id; }
    public void setId(Long id){this.id = id; }
    @Column(name = "gridkey")
    public String getGridKey() {
        return gridKey;
    }
    @Column(name = "wktString")
    public void setGridKey(String gridKey) {
        this.gridKey = gridKey;
    }
    public String getWktString() {
        return wktString;
    }

    public void setWktString(String wktString) {
        this.wktString = wktString;
    }
}
