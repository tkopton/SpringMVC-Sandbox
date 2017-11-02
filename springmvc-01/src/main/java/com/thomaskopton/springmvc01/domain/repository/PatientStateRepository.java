package com.thomaskopton.springmvc01.domain.repository;

import java.util.List;
import java.util.Map;

import com.thomaskopton.springmvc01.domain.PatientState;

public interface PatientStateRepository {
	
	List <PatientState> getAllPatientStates();
	
	List <PatientState> getPatientStatesByHealthState(String level);
	
	List <PatientState> getPatientStatesByFilter(Map<String, List<String>> filterParams);
	
	PatientState getPatientStateByEventId(String eventId);

	void updateCaseState(String eventId, String caseState);
	
	void addPatientSate(PatientState patientState); 
}
