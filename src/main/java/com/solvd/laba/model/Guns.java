package com.solvd.laba.model;

import java.util.Objects;

public class Guns {
    private long id;
    private long serialNumber;
    private long caliber;


    public Guns(){

    }

    public Guns(long serialNumber, long caliber) {
        this.serialNumber = serialNumber;
        this.caliber = caliber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public long getCaliber() {
        return caliber;
    }

    public void setCaliber(long caliber) {
        this.caliber = caliber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guns guns = (Guns) o;
        return id == guns.id && serialNumber == guns.serialNumber && caliber == guns.caliber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serialNumber, caliber);
    }

    @Override
    public String toString() {
        return "Guns{" +
                "id=" + id +
                ", serialNumber=" + serialNumber +
                ", caliber=" + caliber +
                '}';
    }
}
