package com.solvd.laba.model;

import java.util.Objects;

public class Person {

    protected long id;
    protected String name;
    protected int age;
    protected long addressId;
    protected long clothesComplectId;

    public Person() {
    }

    public Person(String name, int age, long addressId, long clothesComplectId) {
        this.name = name;
        this.age = age;
        this.addressId = addressId;
        this.clothesComplectId = clothesComplectId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getAdressId() {
        return addressId;
    }

    public void setAdressId(long adressId) {
        this.addressId = adressId;
    }

    public long getClothesComplectId() {
        return clothesComplectId;
    }

    public void setClothesComplectId(long clothesComplectId) {
        this.clothesComplectId = clothesComplectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person persons = (Person) o;
        return id == persons.id && age == persons.age && addressId == persons.addressId && clothesComplectId == persons.clothesComplectId && Objects.equals(name, persons.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, addressId, clothesComplectId);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", adressId=" + addressId +
                ", clothesComplectId=" + clothesComplectId +
                '}';
    }

}
