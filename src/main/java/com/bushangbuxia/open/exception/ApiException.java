package com.bushangbuxia.open.exception;
/**
 *	@author kalman03
 *	@since	2019-09-03
 */
public class ApiException extends Exception{

	private static final long serialVersionUID = -615823204298013679L;

	public ApiException() {
		super();
	}

	public ApiException(Throwable cause) {
		super(cause);
	}

	public ApiException(String message) {
		super(message);
	}

}
