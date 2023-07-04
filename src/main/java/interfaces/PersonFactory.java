package interfaces;

import com.solvd.laba.model.Person;

public interface PersonFactory {
    Person createPerson( String name, int age, long addressId, long clothesComplectId);
    Person createDriver (long personDriverId, long soldierId, String driveCategory);
    Person createCommander(String title, long personsId, long squadId);
}
