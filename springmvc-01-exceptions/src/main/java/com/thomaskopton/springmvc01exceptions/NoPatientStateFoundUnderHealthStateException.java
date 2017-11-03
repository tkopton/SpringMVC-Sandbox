package com.thomaskopton.springmvc01exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No patient states found under this health status!")
public class NoPatientStateFoundUnderHealthStateException extends RuntimeException{
	private static final long serialVersionUID = 3935230281455340039L;
}
