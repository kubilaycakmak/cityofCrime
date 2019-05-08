package com.cityofCrime.cityofCrime.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int price;
    int units;
    int feedaily;


    public Building() {
        super();
    }

    public Building(int price, int units, int feedaily) {
        this.price = price;
        this.units = units;
        this.feedaily = feedaily;
    }


    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public int getFeedaily() {
        return feedaily;
    }

    public void setFeedaily(int feedaily) {
        this.feedaily = feedaily;
    }
}
