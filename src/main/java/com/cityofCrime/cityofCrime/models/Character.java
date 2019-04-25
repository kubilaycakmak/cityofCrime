package com.cityofCrime.cityofCrime.models;

import javax.persistence.Entity;

@Entity
public class Character extends User{

    private int type; //selection which person
    private int money;
    private int experience;
    private int stamina;
    private int respect;
    private int intelligence;
    private int strengh;
    private int tolerance;
    private int charisma;
    private int power;
//    private int chance;
//    private int spirit;
    private String equipments;

    private int credit;


    public Character() {
    }

    public Character(int type, int money, int experience, int stamina, int respect, int intelligence, int strengh, int tolerance, int charisma, int power, String equipments, int credit) {
        this.type = type;
        this.money = money;
        this.experience = experience;
        this.stamina = stamina;
        this.respect = respect;
        this.intelligence = intelligence;
        this.strengh = strengh;
        this.tolerance = tolerance;
        this.charisma = charisma;
        this.power = power;
        this.equipments = equipments;
        this.credit = credit;
    }

    public Character(int intelligence, int strengh, int tolerance, int charisma) {
        this.intelligence = intelligence;
        this.strengh = strengh;
        this.tolerance = tolerance;
        this.charisma = charisma;
    }

    public Character(int credit) {
        this.credit = credit;
    }

    public Character(int money, int experience, int respect) {
        this.money = money;
        this.experience = experience;
        this.respect = respect;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getRespect() {
        return respect;
    }

    public void setRespect(int respect) {
        this.respect = respect;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getStrengh() {
        return strengh;
    }

    public void setStrengh(int strengh) {
        this.strengh = strengh;
    }

    public int getTolerance() {
        return tolerance;
    }

    public void setTolerance(int tolerance) {
        this.tolerance = tolerance;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

//    public int getChance() {
//        return chance;
//    }
//
//    public void setChance(int chance) {
//        this.chance = chance;
//    }
//
//    public int getSpirit() {
//        return spirit;
//    }
//
//    public void setSpirit(int spirit) {
//        this.spirit = spirit;
//    }

    public String getEquipments() {
        return equipments;
    }

    public void setEquipments(String equipments) {
        this.equipments = equipments;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
