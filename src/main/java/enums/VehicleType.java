package enums;

public enum VehicleType {

    Auto("Auto"),
    Motocycle("Motocycle"),
    Tank("Tank");

    private final String vehicleType;

    public String getVehicleType() {
        return vehicleType;
    }

    VehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

}
