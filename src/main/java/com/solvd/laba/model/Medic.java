package com.solvd.laba.model;

import dao.enums.SpecializationType;

import java.util.Objects;

public class Medic extends Person {
    private long id;
    private SpecializationType specializationType;
    private long personMedicId;

    public Medic() {
    }

    public Medic(SpecializationType specializationType, long personMedicId) {
        this.specializationType = specializationType;
        this.personMedicId = personMedicId;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public SpecializationType getSpecializationType() {
        return specializationType;
    }

    public void setSpecializationType(SpecializationType specializationType) {
        this.specializationType = specializationType;
    }

    public long getPersonMedicId() {
        return personMedicId;
    }

    public void setPersonMedicId(long personMedicId) {
        this.personMedicId = personMedicId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Medic medic = (Medic) o;
        return id == medic.id && personMedicId == medic.personMedicId && specializationType == medic.specializationType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, specializationType, personMedicId);
    }

    @Override
    public String toString() {
        return "Medic{" +
                "id=" + id +
                ", specializationType=" + specializationType +
                ", personMedicId=" + personMedicId +
                '}';
    }
}
