package com.solvd.laba.model;

import java.util.Objects;

public class Medics extends Persons{
    private long id;
    private String specialization;
    private long personId;

    public Medics(){
    }

    public Medics(String specialization, long personId) {
        this.specialization = specialization;
        this.personId = personId;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Medics medics = (Medics) o;
        return id == medics.id && personId == medics.personId && Objects.equals(specialization, medics.specialization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, specialization, personId);
    }

    @Override
    public String toString() {
        return "Medics{" +
                "id=" + id +
                ", specialization='" + specialization + '\'' +
                ", personId=" + personId +
                '}';
    }
}
