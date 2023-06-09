package com.solvd.laba.model;

import java.util.Objects;

public class Squad {
    private long id;
    private String squadName;
    private long commanderId;

    public Squad() {
    }

    public Squad(String squadName, long commanderId) {
        this.squadName = squadName;
        this.commanderId = commanderId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSquadName() {
        return squadName;
    }

    public void setSquadName(String squadName) {
        this.squadName = squadName;
    }

    public long getCommanderId() {
        return commanderId;
    }

    public void setCommanderId(long commanderId) {
        this.commanderId = commanderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Squad squads = (Squad) o;
        return id == squads.id && commanderId == squads.commanderId && Objects.equals(squadName, squads.squadName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, squadName, commanderId);
    }

    @Override
    public String toString() {
        return "Squad{" +
                "id=" + id +
                ", squadName='" + squadName + '\'' +
                ", commanderId=" + commanderId +
                '}';
    }
}
