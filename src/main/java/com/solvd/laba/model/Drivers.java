package com.solvd.laba.model;

import enums.DriveCategory;

import java.util.Objects;

public class Drivers extends Persons{

    private long id;
    private long personId;
    private long soldierId;
    private DriveCategory driveCategory;

    public Drivers(){
    }

    public Drivers(long personId, long soldierId, DriveCategory driveCategory) {
        this.personId = personId;
        this.soldierId = soldierId;
        this.driveCategory = driveCategory;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public long getSoldierId() {
        return soldierId;
    }

    public void setSoldierId(long soldierId) {
        this.soldierId = soldierId;
    }

    public DriveCategory getDriveCategory() {
        return driveCategory;
    }

    public void setDriveCategory(DriveCategory driveCategory) {
        this.driveCategory = driveCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Drivers drivers = (Drivers) o;
        return id == drivers.id && personId == drivers.personId && soldierId == drivers.soldierId && driveCategory == drivers.driveCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, personId, soldierId, driveCategory);
    }

    @Override
    public String toString() {
        return "Drivers{" +
                "id=" + id +
                ", personId=" + personId +
                ", soldierId=" + soldierId +
                ", driveCategory=" + driveCategory +
                '}';
    }
}
