package com.cityofCrime.cityofCrime.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int price;
    int units;
    int feedaily;
    int b1count;
    int b2count;
    int b3count;
    int b4count;
    int b5count;
    int b6count;
    int b7count;
    int b8count;
    int b9count;
    int b10count;


//    @OneToOne
//    @Cascade(CascadeType.ALL)
//    CountBuilding countBuilding;

    public Building() {
        super();
    }

    public Building(int price, int units, int feedaily,
                    int b1count,
                    int b2count,
                    int b3count,
                    int b4count,
                    int b5count,
                    int b6count,
                    int b7count,
                    int b8count,
                    int b9count,
                    int b10count) {
        this.price = price;
        this.units = units;
        this.feedaily = feedaily;
        this.b1count = b1count;
        this.b2count = b2count;
        this.b3count = b3count;
        this.b4count = b4count;
        this.b5count = b5count;
        this.b6count = b6count;
        this.b7count = b7count;
        this.b8count = b8count;
        this.b9count = b9count;
        this.b10count = b10count;

    }

    public int getB1count() {
        return b1count;
    }

    public void setB1count(int b1count) {
        this.b1count = b1count;
    }

    public int getB2count() {
        return b2count;
    }

    public void setB2count(int b2count) {
        this.b2count = b2count;
    }

    public int getB3count() {
        return b3count;
    }

    public void setB3count(int b3count) {
        this.b3count = b3count;
    }

    public int getB4count() {
        return b4count;
    }

    public void setB4count(int b4count) {
        this.b4count = b4count;
    }

    public int getB5count() {
        return b5count;
    }

    public void setB5count(int b5count) {
        this.b5count = b5count;
    }

    public int getB6count() {
        return b6count;
    }

    public void setB6count(int b6count) {
        this.b6count = b6count;
    }

    public int getB7count() {
        return b7count;
    }

    public void setB7count(int b7count) {
        this.b7count = b7count;
    }

    public int getB8count() {
        return b8count;
    }

    public void setB8count(int b8count) {
        this.b8count = b8count;
    }

    public int getB9count() {
        return b9count;
    }

    public void setB9count(int b9count) {
        this.b9count = b9count;
    }

    public int getB10count() {
        return b10count;
    }

    public void setB10count(int b10count) {
        this.b10count = b10count;
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
