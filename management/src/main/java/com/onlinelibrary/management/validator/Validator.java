package com.onlinelibrary.management.validator;

import com.onlinelibrary.management.exception.GenericBookException;

/**
 * Interface for implementing validation logic for various types.
 *
 * @param <T> the type of object to be validated
 */
public interface Validator<T> {

    /**
     * Validates the given object based on the provided parameters.
     *
     * @param object the object to be validated
     * @param objectParam additional parameters needed for validation
     * @throws GenericBookException if the validation fails
     */
    void validate(T object, Object... objectParam) throws GenericBookException;

}
