package com.iotserver.model;


import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Table(name = "vehicle")
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "license_plate")
    private String license_plate;

    @Column(name = "come_in_time")
    private String come_in_time;

    @Column(name = "come_out_time")
    private String come_out_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public String getCome_in_time() {
        return come_in_time;
    }

    public void setCome_in_time(String come_in_time) {
        this.come_in_time = come_in_time;
    }

    public String getCome_out_time() {
        return come_out_time;
    }

    public void setCome_out_time(String come_out_time) {
        this.come_out_time = come_out_time;
    }
}
