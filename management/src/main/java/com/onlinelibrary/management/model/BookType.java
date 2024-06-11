package com.onlinelibrary.management.model;

/**
 * Enumeration representing different types of books.
 */
public enum BookType {
    FICTION(1),
    NON_FICTION(2),
    SCIENCE(3),
    TECHNOLOGY(4),
    HISTORY(5),
    BIOGRAPHY(6);

    private final int value;

    BookType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static BookType fromValue(int value) {
        for (BookType type : BookType.values()) {
            if (type.value == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid BookType value: " + value);
    }
}
