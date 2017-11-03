package com.thomaskopton.springmvc01service;

import java.util.List;
import java.util.Map;

import com.thomaskopton.springmvc01domain.PatientState;

public interface PatientStateService {
	
	void updateAllCaseStates();
	
	List<PatientState> getAllPatientStates();
	
	List <PatientState> getPatientStatesByHealthState(String level);
	
	List <PatientState> getPatientStatesByFilter(Map<String, List<String>> filterParams);
	
	PatientState getPatientStateByEventId(String eventId);
	
	void addPatientSate(PatientState patientState); 
}
