package com.solvd.laba.model;

import java.util.Objects;

public class Driver extends Person{

    private long id;
    private long personDriverId;
    private long soldierId;
    private String driveCategory;

    public Driver(){
    }

    public Driver(long personId, long soldierId, String driveCategory) {
        this.personDriverId = personId;
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

    public long getPersonDriverId() {
        return personDriverId;
    }

    public void setPersonDriverId(long personDriverId) {
        this.personDriverId = personDriverId;
    }

    public long getSoldierId() {
        return soldierId;
    }

    public void setSoldierId(long soldierId) {
        this.soldierId = soldierId;
    }

    public String getDriveCategory() {
        return driveCategory;
    }

    public void setDriveCategory(String driveCategory) {
        this.driveCategory = driveCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Driver drivers = (Driver) o;
        return id == drivers.id && personDriverId == drivers.personDriverId && soldierId == drivers.soldierId && driveCategory == drivers.driveCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, personDriverId, soldierId, driveCategory);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", personsId=" + personDriverId +
                ", soldierId=" + soldierId +
                ", driveCategory=" + driveCategory +
                '}';
    }
}
