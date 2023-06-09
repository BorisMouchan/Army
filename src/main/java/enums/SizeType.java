package enums;

public enum SizeType {

    S("S"),
    M("M"),
    L("L"),
    XL("XL");

    private final String sizeType;

    public String SizeType() {
        return sizeType;
    }

    SizeType(String sizeType) {
        this.sizeType = sizeType;
    }
}
