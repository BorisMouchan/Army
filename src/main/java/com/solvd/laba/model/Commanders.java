package com.solvd.laba.model;

import java.util.Objects;

public class Commanders extends Persons{
    private long id;
    private String title;
    private long personsId;
    private long squadId;

    public Commanders() {
    }

    public Commanders(String title, long personsId, long squadId) {
        this.title = title;
        this.personsId = personsId;
        this.squadId = squadId;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getPersonsId() {
        return personsId;
    }

    public void setPersonsId(long personsId) {
        this.personsId = personsId;
    }

    public long getSquadId() {
        return squadId;
    }

    public void setSquadId(long squadId) {
        this.squadId = squadId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Commanders that = (Commanders) o;
        return id == that.id && personsId == that.personsId && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, title, personsId);
    }

    @Override
    public String toString() {
        return "Commanders{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", personsId=" + personsId +
                '}';
    }
}
