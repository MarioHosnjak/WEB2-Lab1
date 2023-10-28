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
    private Float winpts;

    @Column(name = "drawpts", nullable = false)
    private Float drawpts;

    @Column(name = "losepts", nullable = false)
    private Float losepts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getWinpts() {
        return winpts;
    }

    public void setWinpts(Float winpts) {
        this.winpts = winpts;
    }

    public Float getDrawpts() {
        return drawpts;
    }

    public void setDrawpts(Float drawpts) {
        this.drawpts = drawpts;
    }

    public Float getLosepts() {
        return losepts;
    }

    public void setLosepts(Integer Float) { this.losepts = losepts; }
}