package com.solvd.laba.model;

import java.util.Objects;

public class ClothesComplect {
    private long id;
    private long serialNumber;
    private long stockId;
    private String sizeType;

    ClothesComplect() {
    }

    public ClothesComplect(long serialNumber, long stockId, String sizeType) {
        this.serialNumber = serialNumber;
        this.stockId = stockId;
        this.sizeType = sizeType;
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

    public long getStockId() {
        return stockId;
    }

    public void setStockId(long stockId) {
        this.stockId = stockId;
    }

    public String getSizeType() {
        return sizeType;
    }

    public void setSizeType(String sizeType) {
        this.sizeType = sizeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClothesComplect that = (ClothesComplect) o;
        return id == that.id && serialNumber == that.serialNumber && stockId == that.stockId && sizeType == that.sizeType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serialNumber, stockId, sizeType);
    }

    @Override
    public String toString() {
        return "ClothesComplect{" +
                "id=" + id +
                ", serialNumber=" + serialNumber +
                ", stockId=" + stockId +
                ", sizeType=" + sizeType +
                '}';
    }
}
