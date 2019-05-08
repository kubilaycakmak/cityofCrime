package com.cityofCrime.cityofCrime.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
public class Crew {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    int member;
    int budget;

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    List<Building> buildings;

    public Crew() {
    }

    public Crew(String name, int member, int budget, List<Building> buildings) {
        this.name = name;
        this.member = member;
        this.budget = budget;
        this.buildings = buildings;
    }

    public int getId() {
        return id;
    }

    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }
}
