package com.onlinelibrary.management.dto;

import java.io.Serializable;

import com.onlinelibrary.management.exception.ExceptionBookCode;


/**
 * Class representing a general error, including an error code, description, and optional details.
 */
public class GeneralError implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;
    private String description;
    private Object details;

    /**
     * Default constructor for GeneralError.
     */
    public GeneralError() {
    }

    /**
     * Constructor for GeneralError with code and description.
     *
     * @param code the error code
     * @param description the error description
     */
    public GeneralError(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * Constructor for GeneralError with an ExceptionBookCode.
     *
     * @param exCode the ExceptionBookCode containing the error code and description
     */
    public GeneralError(ExceptionBookCode exCode) {
        this.code = exCode.getCode();
        this.description = exCode.getDescription();
    }

    /**
     * Constructor for GeneralError with an ExceptionBookCode and additional details.
     *
     * @param exCode the ExceptionBookCode containing the error code and description
     * @param details additional details about the error
     */
    public GeneralError(ExceptionBookCode exCode, Object details) {
        this.code = exCode.getCode();
        this.description = exCode.getDescription();
        this.details = details;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public Object getDetails() {
		return details;
	}

	public void setDetails(Object details) {
		this.details = details;
	}
    
}
