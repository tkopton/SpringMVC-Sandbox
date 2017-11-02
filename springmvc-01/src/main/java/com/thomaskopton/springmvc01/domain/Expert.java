package com.thomaskopton.springmvc01.domain;

public class Expert {
	
	private String expertId;
	private String contactInformation;
	private String medicalField;
	private String fieldOfExpertise;
	private String isAlertchain;
	private String isGp;
	private String isCollaboration;
	private String isAnnotation;
	
	public Expert() {
		super();
	}
	
	public Expert(String expertId, String contactInformation, String medicalField, String fieldOfExpertise) {
		this.expertId = expertId;
		this.contactInformation = contactInformation;
		this.medicalField = medicalField;
		this.fieldOfExpertise = fieldOfExpertise;
		this.isGp = "FALSE";
		this.isAlertchain = "FALSE";
		this.isCollaboration = "FALSE";
		this.isAnnotation = "FALSE";
	}

	public String getMedicalField() {
		return medicalField;
	}

	public void setMedicalField(String medicalField) {
		this.medicalField = medicalField;
	}

	public String getIsAlertchain() {
		return isAlertchain;
	}

	public void setIsAlertchain(String isAlertchain) {
		this.isAlertchain = isAlertchain;
	}

	public String getIsGp() {
		return isGp;
	}

	public void setIsGp(String isGp) {
		this.isGp = isGp;
	}

	public String getIsCollaboration() {
		return isCollaboration;
	}

	public void setIsCollaboration(String isCollaboration) {
		this.isCollaboration = isCollaboration;
	}

	public String getIsAnnotation() {
		return isAnnotation;
	}

	public void setIsAnnotation(String isAnnotation) {
		this.isAnnotation = isAnnotation;
	}

	public String getExpertId() {
		return expertId;
	}

	public void setExpertId(String expertId) {
		this.expertId = expertId;
	}

	public String getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}

	public String getFieldOfExpertise() {
		return fieldOfExpertise;
	}

	public void setFieldOfExpertise(String fieldOfExpertise) {
		this.fieldOfExpertise = fieldOfExpertise;
	}
}
