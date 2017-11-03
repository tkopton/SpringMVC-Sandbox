package com.thomaskopton.springmvc01controller.exception;

public class PatientStateNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -694354952032299587L;

	private String healthState;

	public PatientStateNotFoundException(String healthState) {
	      this.healthState = healthState;
	   }

	public String getHealthState() {
		return healthState;
	}
}
