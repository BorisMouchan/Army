package factory;

import interfaces.PersonFactory;

import java.util.Locale;

public class PersonFactoryImpl {
    public static PersonFactory getFactory(String type) {
        switch (type.toLowerCase(Locale.ROOT)) {
            case "person":
                return new ConcretePersonFactory();
            case "commander":
                return new ConcretePersonFactory();
            case "driver":
                return new ConcretePersonFactory();
            default:
                throw new IllegalArgumentException("Invalid type: " + type);
        }
    }
}
