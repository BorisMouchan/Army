package com.solvd.laba.model;

import javax.xml.bind.annotation.*;

import java.util.Objects;

@XmlRootElement(name = "Soldier")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "title", "personSoldierId", "squadSoldierId"})
public class Soldier {
    @XmlAttribute(name="id")
    private long id;
    @XmlElement(name="title")
    private String title;
    @XmlElement(name="personSoldierId")
    private long personSoldierId;
    @XmlElement(name="squadSoldierId")
    private long squadSoldierId;


    public Soldier(){
    }

    public Soldier(long id, String title, long personSoldierId, long squadSoldierId) {
        this.id = id;
        this.title = title;
        this.personSoldierId = personSoldierId;
        this.squadSoldierId = squadSoldierId;
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getPersonSoldierIdId() {
        return personSoldierId;
    }

    public void setPersonSoldierId(long personSoldierId) {
        this.personSoldierId = personSoldierId;
    }

    public long getSquadSoldierId() {
        return squadSoldierId;
    }

    public void setSquadSoldierId(long squadSoldierId) {
        this.squadSoldierId = squadSoldierId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Soldier soldiers = (Soldier) o;
        return id == soldiers.id && personSoldierId == soldiers.personSoldierId && squadSoldierId == soldiers.squadSoldierId && Objects.equals(title, soldiers.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, title, personSoldierId, squadSoldierId);
    }

    @Override
    public String toString() {
        return "Soldier{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", personSoldierId=" + personSoldierId +
                ", squadSoldierId=" + squadSoldierId +
                '}';
    }
}
