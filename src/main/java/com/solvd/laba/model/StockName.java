package com.solvd.laba.model;

import parsers.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "StockName")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id","gunsList","dateLastCheck","stockManagerId","boxCount","gateKeeper"})
public class StockName {
    @XmlAttribute(name = "id")
    private long id;
    @XmlElementWrapper(name = "gunsList")
    @XmlElement(name = "Gun", type = Gun.class)
    private List<Gun> gunsList= new ArrayList<>();
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date dateLastCheck;
    @XmlElement (name = "stockManagerId")
    private long stockManagerId;
    @XmlElement(name = "boxCount")
    private int boxCount;
    @XmlElement(name = "gateKeeper")
    private Soldier gateKeeper;

    public StockName(){
    }

    public StockName(long id, List<Gun> gunsList, Date dateLastCheck, long stockManagerID, int boxCount, Soldier gateKeeper) {
        this.id = id;
        this.gunsList = gunsList;
        this.dateLastCheck = dateLastCheck;
        this.stockManagerId = stockManagerID;
        this.boxCount = boxCount;
        this.gateKeeper = gateKeeper;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Gun> getGunsList() {
        return gunsList;
    }

    public void setGunsList(List<Gun> gunsList) {
        this.gunsList = gunsList;
    }

    public Date getDateLastCheck() {
        return dateLastCheck;
    }

    public void setDateLastCheck(Date dateLastCheck) {
        this.dateLastCheck = dateLastCheck;
    }

    public long getStockManagerId() {
        return stockManagerId;
    }

    public void setStockManagerId(long stockManagerId) {
        this.stockManagerId = stockManagerId;
    }

    public int getBoxCount() {
        return boxCount;
    }

    public void setBoxCount(int boxCount) {
        this.boxCount = boxCount;
    }

    public Soldier getGateKeeper() {
        return gateKeeper;
    }

    public void setGateKeeper(Soldier gateKeeper) {
        this.gateKeeper = gateKeeper;
    }

    @Override
    public String toString() {
        return "StockName{" + "\n" +
                "id=" + id + "\n" +
                ", gunsList=" + gunsList + "\n" +
                ", dateLastCheck=" + dateLastCheck + "\n" +
                ", stockManagerId=" + stockManagerId + "\n" +
                ", boxCount=" + boxCount + "\n"+
                ", gateKeeper=" + gateKeeper + "\n"+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockName stockName = (StockName) o;
        return id == stockName.id && stockManagerId == stockName.stockManagerId && boxCount == stockName.boxCount && Objects.equals(gunsList, stockName.gunsList) && Objects.equals(dateLastCheck, stockName.dateLastCheck) && Objects.equals(gateKeeper, stockName.gateKeeper);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gunsList, dateLastCheck, stockManagerId, boxCount, gateKeeper);
    }
}
