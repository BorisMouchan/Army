package com.solvd.laba.model;

import java.util.Objects;

public class Vehicle {

    private long id;
    private int year;
    private long stockId;
    private long driverId;
    private int maxSpeed;
    private String vehicleType;

    public Vehicle() {
    }

    public Vehicle(int year, long stockId, long driverId, int maxSpeed, String vehicleType) {
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

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicles = (Vehicle) o;
        return id == vehicles.id && year == vehicles.year && stockId == vehicles.stockId && driverId == vehicles.driverId && maxSpeed == vehicles.maxSpeed && vehicleType == vehicles.vehicleType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, stockId, driverId, maxSpeed, vehicleType);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", year=" + year +
                ", stockId=" + stockId +
                ", driverId=" + driverId +
                ", maxSpeed=" + maxSpeed +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
