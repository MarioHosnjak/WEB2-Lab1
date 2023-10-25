package com.WEB2.backend.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "scoringsystem")
@Entity
public class Scoringsystem {
    @Id
    @Column(name = "sportname", nullable = false, length = 25)
    private String id;

    @Column(name = "winpts", nullable = false)
    private Integer winpts;

    @Column(name = "drawpts", nullable = false)
    private Integer drawpts;

    @Column(name = "losepts", nullable = false)
    private Integer losepts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getWinpts() {
        return winpts;
    }

    public void setWinpts(Integer winpts) {
        this.winpts = winpts;
    }

    public Integer getDrawpts() {
        return drawpts;
    }

    public void setDrawpts(Integer drawpts) {
        this.drawpts = drawpts;
    }

    public Integer getLosepts() {
        return losepts;
    }

    public void setLosepts(Integer losepts) { this.losepts = losepts; }
}