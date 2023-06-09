package com.solvd.laba.model;

import java.util.Objects;

public class StockName {
    private long id;
    private String stockName;
    private long stockManagerID;

    public StockName(){
    }

    public StockName(String stockName, long stockManagerID) {
        this.stockName = stockName;
        this.stockManagerID = stockManagerID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public long getStockManagerID() {
        return stockManagerID;
    }

    public void setStockManagerID(long stockManagerID) {
        this.stockManagerID = stockManagerID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockName stockName1 = (StockName) o;
        return id == stockName1.id && stockManagerID == stockName1.stockManagerID && Objects.equals(stockName, stockName1.stockName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stockName, stockManagerID);
    }

    @Override
    public String toString() {
        return "StockName{" +
                "id=" + id +
                ", stockName='" + stockName + '\'' +
                ", stockManagerID=" + stockManagerID +
                '}';
    }
}
