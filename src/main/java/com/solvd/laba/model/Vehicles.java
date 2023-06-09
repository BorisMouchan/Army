package com.solvd.laba.model;

import enums.VehicleType;

import java.util.Objects;

public class Vehicles {

    private long id;
    private int year;
    private long stockId;
    private long driverId;
    private int maxSpeed;
    private VehicleType vehicleType;

    public Vehicles(){
    }

    public Vehicles(int year, long stockId, long driverId, int maxSpeed, VehicleType vehicleType) {
        this.year = year;
        this.stockId = stockId;
        this.driverId = driverId;
        this.maxSpeed = maxSpeed;
        this.vehicleType = vehicleType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getStockId() {
        return stockId;
    }

    public void setStockId(long stockId) {
        this.stockId = stockId;
    }

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicles vehicles = (Vehicles) o;
        return id == vehicles.id && year == vehicles.year && stockId == vehicles.stockId && driverId == vehicles.driverId && maxSpeed == vehicles.maxSpeed && vehicleType == vehicles.vehicleType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, stockId, driverId, maxSpeed, vehicleType);
    }

    @Override
    public String toString() {
        return "Vehicles{" +
                "id=" + id +
                ", year=" + year +
                ", stockId=" + stockId +
                ", driverId=" + driverId +
                ", maxSpeed=" + maxSpeed +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
