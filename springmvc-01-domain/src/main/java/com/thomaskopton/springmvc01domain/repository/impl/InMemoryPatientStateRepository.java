package com.thomaskopton.springmvc01domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.thomaskopton.springmvc01domain.PatientState;
import com.thomaskopton.springmvc01domain.repository.PatientStateRepository;
import com.thomaskopton.springmvc01exceptions.PatientStateNotFoundException;

@Repository
public class InMemoryPatientStateRepository implements PatientStateRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<PatientState> getAllPatientStates() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<PatientState> result = jdbcTemplate.query("SELECT * FROM patientstates", params, new PatientStateMapper());

		return result;
	}

	@Override
	public List<PatientState> getPatientStatesByHealthState(String healthState) {
		String SQL = "SELECT * FROM PATIENTSTATES WHERE HEALTHSTATE = :healthState";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("healthState", healthState);

		try {
			return (List<PatientState>) jdbcTemplate.queryForObject(SQL, params, new PatientStateMapper());
		} catch (DataAccessException e) {
			throw new PatientStateNotFoundException(healthState);
		}
	}

	@Override
	public List<PatientState> getPatientStatesByFilter(Map<String, List<String>> filterParams) {
		String SQL = "SELECT * FROM PATIENTSTATES WHERE HEALTHSTATE IN ( :healthstates ) AND EMOTIONALSTATE IN ( :emotionalstates)";

		return jdbcTemplate.query(SQL, filterParams, new PatientStateMapper());
	}

	@Override
	public PatientState getPatientStateByEventId(String eventId) {
		String SQL = "SELECT * FROM PATIENTSTATES WHERE EVENTID = :eventId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("eventId", eventId);

		return jdbcTemplate.queryForObject(SQL, params, new PatientStateMapper());
	}

	@Override
	public void addPatientSate(PatientState patientState) {
		String SQL = "INSERT INTO PATIENTSTATES (EVENTID, " + "CASESTATE," + "PATIENTID," + "HEALTHSTATE,"
				+ "EMOTIONALSTATE," + "PATIENTPOSITION," + "PATIENTLOCATION," + "AUDIOSEQUENZE," + "VIDEOSEQUENZE)"
				+ "VALUES (:eventId, :caseState, :patientId, :healthState, :emotionalState, :patientPosition, :patientLocation, :audioSequenze, :videoSequenze)";

		Map<String, Object> params = new HashMap<>();
		params.put("eventId", patientState.getEventId());
		params.put("caseState", patientState.getCaseState());
		params.put("patientId", patientState.getPatientId());
		params.put("healthState", patientState.getHealthState());
		params.put("emotionalState", patientState.getEmotionalState());
		params.put("patientPosition", patientState.getPatientPosition());
		params.put("patientLocation", patientState.getPatientLocation());
		params.put("audioSequenze", patientState.getAudioSequenze());
		params.put("videoSequenze", patientState.getVideoSequenze());

		jdbcTemplate.update(SQL, params);
	}

	private static final class PatientStateMapper implements RowMapper<PatientState> {
		public PatientState mapRow(ResultSet rs, int rowNum) throws SQLException {
			PatientState patientState = new PatientState();
			patientState.setEventId(rs.getString("EVENTID"));
			patientState.setCaseState(rs.getString("CASESTATE"));
			patientState.setPatientId(rs.getString("PATIENTID"));
			patientState.setHealthState(rs.getString("HEALTHSTATE"));
			patientState.setEmotionalState(rs.getString("EMOTIONALSTATE"));
			patientState.setPatientPosition(rs.getString("PATIENTPOSITION"));
			patientState.setPatientLocation(rs.getString("PATIENTLOCATION"));
			patientState.setAudioSequenze(rs.getString("AUDIOSEQUENZE"));
			patientState.setVideoSequenze(rs.getString("VIDEOSEQUENZE"));

			return patientState;
		}

	}

	@Override
	public void updateCaseState(String eventId, String caseState) {
		String SQL = "UPDATE PATIENTSTATES SET CASESTATE = :caseState WHERE EVENTID = :eventId";
		Map<String, Object> params = new HashMap<>();
		params.put("caseState", caseState);
		params.put("eventId", eventId);
		jdbcTemplate.update(SQL, params);
	}
}
