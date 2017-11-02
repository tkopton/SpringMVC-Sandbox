package com.thomaskopton.springmvc01domain;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PatientState implements Serializable {
	
	private static final long serialVersionUID = 3678107792576131001L;
	
	private String eventId;
	private String caseState;
	private String patientId;
	private String healthState;
	private String emotionalState;
	private String patientPosition;
	private String patientLocation;
	private String audioSequenze;
	private String videoSequenze;
	@JsonIgnore
	private MultipartFile actionPlan01;
	
	public PatientState() {
		super();
	}
	
	public PatientState(String eventId, String patientId, String caseState) {
		this.eventId = eventId;
		this.patientId = patientId;
		this.caseState = caseState;
	}

	public String getEmotionalState() {
		return emotionalState;
	}

	public void setEmotionalState(String emotionalState) {
		this.emotionalState = emotionalState;
	}

	public String getHealthState() {
		return healthState;
	}

	public void setHealthState(String healthState) {
		this.healthState = healthState;
	}

	public String getPatientPosition() {
		return patientPosition;
	}

	public void setPatientPosition(String patientPosition) {
		this.patientPosition = patientPosition;
	}

	public String getPatientLocation() {
		return patientLocation;
	}

	public void setPatientLocation(String patientLocation) {
		this.patientLocation = patientLocation;
	}

	public String getAudioSequenze() {
		return audioSequenze;
	}

	public void setAudioSequenze(String audioSequenze) {
		this.audioSequenze = audioSequenze;
	}

	public String getVideoSequenze() {
		return videoSequenze;
	}

	public void setVideoSequenze(String videoSequenze) {
		this.videoSequenze = videoSequenze;
	}

	public String getEventId() {
		return eventId;
	}

	public String getPatientId() {
		return patientId;
	}
	
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getCaseState() {
		return caseState;
	}

	public void setCaseState(String caseState) {
		this.caseState = caseState;
	}

	public MultipartFile getActionPlan01() {
		return actionPlan01;
	}

	public void setActionPlan01(MultipartFile actionPlan01) {
		this.actionPlan01 = actionPlan01;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PatientState other = (PatientState) obj;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		return result;
	}
}
