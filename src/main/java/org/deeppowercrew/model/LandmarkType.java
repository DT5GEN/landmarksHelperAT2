package org.deeppowercrew.model;

public enum LandmarkType {
    HISTORICAL("Historical"),
    MONUMENT("Monument"),
    TEMPLE("Temple"),
    RELIGIOUS("Religious"),
    NATURAL("Natural");

    private final String value;

    LandmarkType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static LandmarkType fromValue(String value) {
        for (LandmarkType type : LandmarkType.values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown LandmarkType: " + value);
    }
}
