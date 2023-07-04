package factory;

import com.solvd.laba.model.Commander;
import com.solvd.laba.model.Driver;
import com.solvd.laba.model.Person;
import interfaces.PersonFactory;

public class ConcretePersonFactory implements PersonFactory {
    @Override
    public Person createPerson( String name, int age, long addressId, long clothesComplectId) {
        return new Person(name, age, addressId, clothesComplectId);
    }

    @Override
    public Person createCommander(String title, long personsId, long squadId) {
        return new Commander(title,personsId,squadId);
    }

    @Override
    public Person createDriver(long personDriverId, long soldierId, String driveCategory) {
        return new Driver(personDriverId,  soldierId, driveCategory);
    }
}
