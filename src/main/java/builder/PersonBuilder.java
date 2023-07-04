package builder;

import com.solvd.laba.model.Person;

public  class PersonBuilder {
    private long id;
    private String name;
    private int age;
    private long addressId;
    private long clothesComplectId;

    public PersonBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setAddressId(long addressId) {
        this.addressId = addressId;
        return this;
    }

    public PersonBuilder setClothesComplectId(long clothesComplectId) {
        this.clothesComplectId = clothesComplectId;
        return this;
    }

    public Person build() {
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        person.setAge(age);
        person.setAdressId(addressId);
        person.setClothesComplectId(clothesComplectId);
        return person;
    }

    @Override
    public String toString() {
        return "PersonBuilder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", addressId=" + addressId +
                ", clothesComplectId=" + clothesComplectId +
                '}';
    }
}
