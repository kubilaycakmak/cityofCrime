package com.cityofCrime.cityofCrime.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Equipments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String equipmentName;
    int power;
    int price;

    public Equipments() {
        super();
    }

    public Equipments(String equipmentName, int power, int price) {
        this.equipmentName = equipmentName;
        this.power = power;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
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
