package dao.enums;

public enum SpecializationType {
    Doctor("DOCTOR"),
    Nurse("NURSE");


    private final String specializationType;

    public String getSpecializationType() {
        return specializationType;
    }

    SpecializationType(String specializationType) {
        this.specializationType = specializationType;
    }
}
