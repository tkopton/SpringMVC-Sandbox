package com.thomaskopton.springmvc01service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomaskopton.springmvc01domain.repository.PatientStateRepository;
import com.thomaskopton.springmvc01service.PatientStateService;
import com.thomaskopton.springmvc01domain.PatientState;

@Service
public class PatientStateServiceImpl implements PatientStateService {

	@Autowired
	private PatientStateRepository patientStateRepository;

	@Override
	public void updateAllCaseStates() {
		List<PatientState> allPatientsStates = patientStateRepository.getAllPatientStates();

		for (PatientState patientState : allPatientsStates) {
			if (patientState.getCaseState().equalsIgnoreCase("OPEN"))
				patientStateRepository.updateCaseState(patientState.getEventId(), "REVIEWED");
		}
	}

	@Override
	public List<PatientState> getAllPatientStates() {
		return patientStateRepository.getAllPatientStates();
	}

	@Override
	public List<PatientState> getPatientStatesByHealthState(String level) {
		return patientStateRepository.getPatientStatesByHealthState(level);
	}

	@Override
	public List<PatientState> getPatientStatesByFilter(Map<String, List<String>> filterParams) {
		return patientStateRepository.getPatientStatesByFilter(filterParams);
	}

	@Override
	public PatientState getPatientStateByEventId(String eventId) {
		return patientStateRepository.getPatientStateByEventId(eventId);
	}

	@Override
	public void addPatientSate(PatientState patientState) {
		patientStateRepository.addPatientSate(patientState);
	}
}
