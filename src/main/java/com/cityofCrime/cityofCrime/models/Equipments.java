package com.cityofCrime.cityofCrime.models;

import javax.persistence.*;

@Entity
public class Equipments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int power;
    int price;

    public Equipments() {
        super();
    }

    public Equipments(int power, int price) {
        this.power = power;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
