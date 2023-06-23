package com.solvd.laba.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;

import java.util.Objects;

@XmlRootElement(name = "Gun")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "serialNumber", "caliber"})
public class Gun {
    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private long id;
    @XmlElement(name = "serialNumber")
    @JsonProperty("serialNumber")
    private long serialNumber;
    @XmlElement(name = "caliber")
    @JsonProperty("caliber")
    private long caliber;


    public Gun() {
    }

    public Gun(long id, long serialNumber, long caliber) {
        this.id = id;
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
        Gun guns = (Gun) o;
        return id == guns.id && serialNumber == guns.serialNumber && caliber == guns.caliber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serialNumber, caliber);
    }

    @Override
    public String toString() {
        return "Gun{" +
                "id=" + id +
                ", serialNumber=" + serialNumber +
                ", caliber=" + caliber +
                '}';
    }
}
