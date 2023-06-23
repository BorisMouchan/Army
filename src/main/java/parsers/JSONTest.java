package parsers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.laba.model.Gun;
import com.solvd.laba.model.Soldier;
import com.solvd.laba.model.StockName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JSONTest {
    private static final Logger LOGGER = LogManager.getLogger(JSONTest.class);

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Gun> guns = new ArrayList<>();
        guns.add(new Gun(1, 1888888, 33));
        guns.add(new Gun(2, 1999999, 44));
        guns.add(new Gun(3, 1000000, 55));
        Soldier soldierGateKepper = new Soldier(5, "Top-Sergant", 22, 33);
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse("2023-06-14");
        } catch (ParseException e) {
            LOGGER.error(e.getMessage());
        }

        StockName firstStock = new StockName(1, guns, date, 007, 10, soldierGateKepper);

        File file = new File(System.getProperty("user.dir") + "/src/main/resources/stocknameToJSON.json");
        try {
            objectMapper.writeValue(file, firstStock);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.info("Json writing  is done.");

        File fileInput = new File(System.getProperty("user.dir") + "/src/main/resources/stocknameparse.json");
        JavaType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, StockName.class);

        try {
            List<StockName> stockName = objectMapper.readValue(fileInput, javaType);

            for (StockName s : stockName) {
                LOGGER.info(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.info("Json reading  is done.");

    }
}