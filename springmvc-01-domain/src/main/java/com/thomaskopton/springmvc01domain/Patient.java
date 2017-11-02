package com.thomaskopton.springmvc01domain;

public class Patient {
	
	private String patientId;
	private String sureName;
	private String givenName;
	private String careRecord;
	
	public Patient() {
		super();
	}
	
	public Patient(String patientId, String givenName, String sureName) {
		this.patientId = patientId;
		this.sureName = sureName;
		this.givenName = givenName;
	}

	public String getCareRecord() {
		return careRecord;
	}

	public void setCareRecord(String careRecord) {
		this.careRecord = careRecord;
	}

	public String getPatientId() {
		return patientId;
	}

	public String getSureName() {
		return sureName;
	}

	public String getGivenName() {
		return givenName;
	}
	
	
}
