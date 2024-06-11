package com.onlinelibrary.management.validator;

/**
 * Interface providing utility methods for validation and data consistency checks.
 */
public interface ObjectValidator {

    /**
     * Checks if a given string is null or empty.
     *
     * @param str the string to check
     * @return true if the string is null or empty, false otherwise
     */
    default boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    /**
     * Returns a valid string value. If the input string is not null, it returns the input.
     * Otherwise, it returns the optional string.
     *
     * @param input the input string to validate
     * @param optional the optional string to return if the input is null
     * @return the input string if it is not null, otherwise the optional string
     */
    default String getValidString(String input, String optional) {
        return input != null ? input : optional;
    }

    /**
     * Returns a valid integer value. If the input integer is not null, it returns the input.
     * Otherwise, it returns the optional integer.
     *
     * @param input the input integer to validate
     * @param optional the optional integer to return if the input is null
     * @return the input integer if it is not null, otherwise the optional integer
     */
    default Integer getValidInteger(Integer input, Integer optional) {
        return input != null ? input : optional;
    }

    /**
     * Returns a valid double value. If the input double is not null, it returns the input.
     * Otherwise, it returns the optional double.
     *
     * @param input the input double to validate
     * @param optional the optional double to return if the input is null
     * @return the input double if it is not null, otherwise the optional double
     */
    default Double getValidDouble(Double input, Double optional) {
        return input != null ? input : optional;
    }
}
