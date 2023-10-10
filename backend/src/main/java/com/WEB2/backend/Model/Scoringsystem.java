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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}