package org.pracainzynierska.model;

public enum PaymentType {
    BY_TANSFER("Przelew"),
    BY_CARD("Karta");

    private final String displayValue;
    PaymentType(String displayValue) {
        this.displayValue=displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
