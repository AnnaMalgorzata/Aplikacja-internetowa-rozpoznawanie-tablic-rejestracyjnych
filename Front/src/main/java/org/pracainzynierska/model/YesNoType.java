package org.pracainzynierska.model;

public enum YesNoType {
    YES("Tak"),
    NO("Nie");

    private final String displayValue;
    YesNoType(String displayValue) {
        this.displayValue=displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
