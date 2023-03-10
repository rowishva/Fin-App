package com.fin.constants;

public final class ApplicationConstants {

	// ServiceEndpoints
	public static final String SERVICE_ENDPOINT_API_CAR = "api/car";
	public static final String SERVICE_ENDPOINT_CAR_TYPE = "/{carType}";
	public static final String SERVICE_ENDPOINT_ID = "/{id}";
	//Constants and error message
	public static final String SUCCESS = "SUCCESS";
	public static final String ERROR_MSG_MALFORMED_JSON_REQUEST = "Malformed JSON request";
	public static final String ERROR_MSG_INTERNAL_SERVER_ERROR = "Internal Server error Please contact administrator";
	public static final String ERROR_MSG_MISSING_MANDATORY_PARAMETERS = "Bad request missing mandatory parameters";
	public static final String ERROR_MSG_CAR_TYPE_NOT_FOUND = "Car Type Not Found : ";
	public static final String ERROR_MSG_CAR_NOT_FOUND = "Car Not Found : ";

}
