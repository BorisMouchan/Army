package parsers;

import com.solvd.laba.model.Commander;
import com.solvd.laba.model.Driver;
import com.solvd.laba.model.Person;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StaxParser {
    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {
        String file = System.getProperty("user.dir") + "/src/main/resources/army.xml";
        FileInputStream fileName = new FileInputStream(file);

        List<Person> personList = null;
        List<Commander> commanderList = null;
        List<Driver> driverList = null;
        Person person = null;
        Commander commander = null;
        Driver driver = null;
        String tagContent = null;

        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader =
                factory.createXMLStreamReader(fileName);

        while (reader.hasNext()) {
            int event = reader.next();

            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    if ("Person".equals(reader.getLocalName())) {
                        person = new Person();
                        person.setId(Long.parseLong(reader.getAttributeValue(0)));
                    }
                    if ("Persons".equals(reader.getLocalName())) {
                        personList = new ArrayList<>();
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    tagContent = reader.getText().trim();
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    switch (reader.getLocalName()) {
                        case "Person":
                            personList.add(person);
                            break;
                        case "name":
                            person.setName(tagContent);
                            break;
                        case "age":
                            person.setAge(Integer.parseInt(tagContent));
                            break;
                        case "addressId":
                            person.setAdressId(Long.parseLong(tagContent));
                            break;
                        case "clothesComplectId":
                            person.setClothesComplectId(Long.parseLong(tagContent));
                            break;
                    }
                    break;
            }

            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    if ("Commander".equals(reader.getLocalName())) {
                        commander = new Commander();
                        commander.setId(Long.parseLong(reader.getAttributeValue(0)));
                    }
                    if ("Commanders".equals(reader.getLocalName())) {
                        commanderList = new ArrayList<>();
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    tagContent = reader.getText().trim();
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    switch (reader.getLocalName()) {
                        case "Commander":
                            commanderList.add(commander);
                            break;
                        case "title":
                            commander.setTitle(tagContent);
                            break;
                        case "personsId":
                            commander.setPersonsId(Long.parseLong(tagContent));
                            break;
                        case "squadId":
                            commander.setSquadId(Long.parseLong(tagContent));
                            break;
                    }
                    break;
            }
            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    if ("Driver".equals(reader.getLocalName())) {
                        driver = new Driver();
                        driver.setId(Long.parseLong(reader.getAttributeValue(0)));
                    }
                    if ("Drivers".equals(reader.getLocalName())) {
                        driverList = new ArrayList<>();
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    tagContent = reader.getText().trim();
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    switch (reader.getLocalName()) {
                        case "Driver":
                            driverList.add(driver);
                            break;
                        case "personId":
                            driver.setPersonDriverId(Long.parseLong(tagContent));
                            break;
                        case "soldierId":
                            driver.setSoldierId(Long.parseLong(tagContent));
                            break;
                        case "driveCategory":
                            driver.setDriveCategory(tagContent);
                            break;
                    }
                    break;
            }
        }

        for (Person p : personList) {
            System.out.println(p);
        }
        for (Commander commander1 : commanderList) {
            System.out.println(commander1);
        }
        for (Driver driver1 : driverList) {
            System.out.println(driver1);
        }
    }
}

