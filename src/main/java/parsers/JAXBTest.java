package parsers;

import com.solvd.laba.model.Gun;
import com.solvd.laba.model.Soldier;
import com.solvd.laba.model.StockName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class JAXBTest {
    private static final Logger LOGGER = LogManager.getLogger(JAXBTest.class);

    public static void main(String[] args) {
        JAXBmarshaling();
//        JAXBunmarshaling();
//        StockName test = JAXBunmarshaling();
//        LOGGER.info(test);

    }

    public static void JAXBmarshaling() {

        List<Gun> guns = new ArrayList<>();
        guns.add(new Gun(1, 33333333, 33));
        guns.add(new Gun(2, 44444444, 44));
        guns.add(new Gun(3, 55555555, 55));
        Soldier soldierGateKepper = new Soldier(1, "Recruit", 101, 9);
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse("1999-11-01");
        } catch (ParseException e) {
            LOGGER.error(e.getMessage());
        }

        StockName firstStock = new StockName(1, guns, date, 2, 3, soldierGateKepper);

        JAXBContext context;
        try {
            context = JAXBContext.newInstance(StockName.class, Gun.class, Soldier.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(firstStock, new File(System.getProperty("user.dir") + "/src/main/resources/JAXBmarsh.xml"));
            LOGGER.info("Marshalling is done.");
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public static StockName JAXBunmarshaling() {

        JAXBContext context;
        StockName secondStock = new StockName();
        try {
            context = JAXBContext.newInstance(StockName.class, Gun.class, Soldier.class);
            secondStock = (StockName) context.createUnmarshaller()
                    .unmarshal(new FileReader(System.getProperty("user.dir") + "/src/main/resources/StockName_input.xml"));
            LOGGER.info("Unmarshalling is done.");
        } catch (JAXBException e) {
            LOGGER.error(e.getMessage());
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getMessage());
        }
        return secondStock;
    }
}
