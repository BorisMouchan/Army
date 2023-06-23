import com.solvd.laba.model.Address;
import com.solvd.laba.model.Medic;
import com.solvd.laba.model.Person;
import dao.enums.SpecializationType;
import dao.myBatisImpl.AddressDAO;
import dao.myBatisImpl.MedicDAO;
import dao.myBatisImpl.PersonDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.List;

public class Army {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(Army.class);
    public static void main(String[] args) {
        LOGGER.info("hello");
//        testJDBCAddressDAO();
//        testMyBatisAddressDAO();
//        testMyBatisPersonDAO();
        testMyBatisMedicDAO();
    }

//    public static void testJDBCAddressDAO() {
//        AddressDAO addressDAO = new AddressDAO();
//        Address addressTestInsert = new Address("Australia", "ul. Werepodorovo");
//        addressDAO.saveEntity(addressTestInsert);
//        Address addressById = addressDAO.getEntityById(1);
//        LOGGER.info("An object read from the database: " + addressById);
//        Address addressById2 = addressDAO.getEntityById(8);
//        LOGGER.info("An object read from the database: " + addressById2);
//        addressById.setCity("Podmoskovie");
//        addressById.setStreet("ul. Pushkina");
//        addressDAO.updateEntity(addressById);
//        LOGGER.info("The updated object: " + addressDAO.getEntityById(1));
//        addressDAO.removeEntity(16);
//        addressDAO.removeEntity(15);
//    }

//    public static void testMyBatisAddressDAO(){
//        AddressDAO addressDAO = new AddressDAO();
//        List<Address> address = addressDAO.getCityByStreet("ul. Pushkina");
//        LOGGER.info(address);
//        LOGGER.info(addressDAO.getAll());
//
//        addressDAO.getCityByStreet("ul. Werepodorovo");
//        LOGGER.info(addressDAO.getCityByStreet("ul. Werepodorovo"));



//        Address addressTestInsert = new Address("Rio de Janeiro", "ul. Depazamanova");
//        addressDAO.saveEntity(addressTestInsert);
//
//        LOGGER.info("An object read from the database: " + addressDAO.getEntityById(11));
//
//        addressDAO.removeEntity(16);
//    }

//    public static void testMyBatisPersonDAO() {
//        PersonDAO personDAO = new PersonDAO();
//        Person person = personDAO.getPersonById(4);
//        person.setClothesComplectId(2);
//        person.setAdressId(10);
//        personDAO.updateEntity(person);
//    }

    public static void testMyBatisMedicDAO(){
        MedicDAO medicDAO= new MedicDAO();
//        Medic medicToInsert = new Medic(SpecializationType.Doctor,4);
//        Medic medicToInsert2 = new Medic(SpecializationType.Nurse,4);
//        Medic medicToInsert3 = new Medic(SpecializationType.Doctor,4);
//        medicDAO.saveEntity(medicToInsert2);
//        medicDAO.saveEntity(medicToInsert3);
//         ;
//         LOGGER.info(medicDAO.getMedicBySpecialization(SpecializationType.Doctor));

        Medic medicById = medicDAO.getEntityById(3);
        medicById.setPersonMedicId(3);
        medicById.setSpecializationType(SpecializationType.Doctor);
        medicDAO.updateEntity(medicById);
        LOGGER.info(medicDAO.getAll());

    }
}
