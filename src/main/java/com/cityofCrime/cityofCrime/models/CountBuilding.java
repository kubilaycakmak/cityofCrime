package com.cityofCrime.cityofCrime.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CountBuilding {

    @Id
    int id;

    int buildingCount1;
    int buildingCount2;
    int buildingCount3;
    int buildingCount4;
    int buildingCount5;
    int buildingCount6;
    int buildingCount7;
    int buildingCount8;
    int buildingCount9;
    int buildingCount10;

    public CountBuilding() {
    }

    public CountBuilding(int buildingCount1, int buildingCount2, int buildingCount3, int buildingCount4, int buildingCount5, int buildingCount6, int buildingCount7, int buildingCount8, int buildingCount9, int buildingCount10) {
        this.buildingCount1 = buildingCount1;
        this.buildingCount2 = buildingCount2;
        this.buildingCount3 = buildingCount3;
        this.buildingCount4 = buildingCount4;
        this.buildingCount5 = buildingCount5;
        this.buildingCount6 = buildingCount6;
        this.buildingCount7 = buildingCount7;
        this.buildingCount8 = buildingCount8;
        this.buildingCount9 = buildingCount9;
        this.buildingCount10 = buildingCount10;
    }

    public int getId() {
        return id;
    }

    public int getBuildingCount1() {
        return buildingCount1;
    }

    public void setBuildingCount1(int buildingCount1) {
        this.buildingCount1 = buildingCount1;
    }

    public int getBuildingCount2() {
        return buildingCount2;
    }

    public void setBuildingCount2(int buildingCount2) {
        this.buildingCount2 = buildingCount2;
    }

    public int getBuildingCount3() {
        return buildingCount3;
    }

    public void setBuildingCount3(int buildingCount3) {
        this.buildingCount3 = buildingCount3;
    }

    public int getBuildingCount4() {
        return buildingCount4;
    }

    public void setBuildingCount4(int buildingCount4) {
        this.buildingCount4 = buildingCount4;
    }

    public int getBuildingCount5() {
        return buildingCount5;
    }

    public void setBuildingCount5(int buildingCount5) {
        this.buildingCount5 = buildingCount5;
    }

    public int getBuildingCount6() {
        return buildingCount6;
    }

    public void setBuildingCount6(int buildingCount6) {
        this.buildingCount6 = buildingCount6;
    }

    public int getBuildingCount7() {
        return buildingCount7;
    }

    public void setBuildingCount7(int buildingCount7) {
        this.buildingCount7 = buildingCount7;
    }

    public int getBuildingCount8() {
        return buildingCount8;
    }

    public void setBuildingCount8(int buildingCount8) {
        this.buildingCount8 = buildingCount8;
    }

    public int getBuildingCount9() {
        return buildingCount9;
    }

    public void setBuildingCount9(int buildingCount9) {
        this.buildingCount9 = buildingCount9;
    }

    public int getBuildingCount10() {
        return buildingCount10;
    }

    public void setBuildingCount10(int buildingCount10) {
        this.buildingCount10 = buildingCount10;
    }
}
