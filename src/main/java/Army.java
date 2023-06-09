import com.solvd.laba.model.Address;
import com.solvd.laba.model.Commanders;
import dao.jdbcMySQLImpl.AddressDAO;
import dao.jdbcMySQLImpl.CommandersDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Army {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(Army.class);
    public static void main(String[] args) {


        LOGGER.info("hello");
        testJDBCAddressDAO();

    }
    public static void testJDBCAddressDAO() {
        AddressDAO addressDAO = new AddressDAO();
//        Address addressTestInsert = new Address("Germany", "ul. Werepodorovo");
//        addressDAO.saveEntity(addressTestInsert);
        Address addressById = addressDAO.getEntityById(1);
        LOGGER.info("An object read from the database: " + addressById);
        Address addressById2 = addressDAO.getEntityById(7);
        LOGGER.info("An object read from the database: " + addressById2);
//        addressById.setCity("Paris");
//        addressById.setStreet("ul. Jemope");
//        addressDAO.updateEntity(addressById);
//        LOGGER.info("The updated object: " + addressDAO.getEntityById(7));
//        addressDAO.removeEntity(6);
    }
}
