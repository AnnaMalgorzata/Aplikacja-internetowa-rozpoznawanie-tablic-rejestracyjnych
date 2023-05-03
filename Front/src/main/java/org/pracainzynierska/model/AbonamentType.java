package org.pracainzynierska.model;


public enum AbonamentType {
    FOR_SEASON("Sezonowy"),
    FOR_NIGHT("Nocny"),
    FOR_DAY("Dzienny"),
    FOR_WEEKEND("Weekendowy");

    private final String displayValue;
    AbonamentType(String displayValue) {
        this.displayValue=displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
