package com.solvd.laba.model;

import java.util.Objects;

public class StockManagers extends Persons{

    private long id;
    private long stockId;
    private long personId;

    public StockManagers(){
    }

    public StockManagers(long stockId, long personId) {
        this.stockId = stockId;
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

    public long getStockId() {
        return stockId;
    }

    public void setStockId(long stockId) {
        this.stockId = stockId;
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
        StockManagers that = (StockManagers) o;
        return id == that.id && stockId == that.stockId && personId == that.personId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, stockId, personId);
    }

    @Override
    public String toString() {
        return "StockManagers{" +
                "id=" + id +
                ", stockId=" + stockId +
                ", personId=" + personId +
                '}';
    }
}
