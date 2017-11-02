package com.thomaskopton.springmvc01domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.thomaskopton.springmvc01domain.Expert;
import com.thomaskopton.springmvc01domain.repository.ExpertRepository;

@Repository
public class InMemoryExpertRepository implements ExpertRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Expert> getAllExperts() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<Expert> result = jdbcTemplate.query("SELECT * FROM experts", params, new ExpertMapper());

		return result;
	}
	
	private static final class ExpertMapper implements RowMapper<Expert> {
		public Expert mapRow(ResultSet rs, int rowNum) throws SQLException {
			Expert expert = new Expert();
			expert.setExpertId(rs.getString("EXPERTID"));
			expert.setContactInformation(rs.getString("CONTACTINORMATION"));
			expert.setMedicalField(rs.getString("MEDICALFIELD"));
			expert.setFieldOfExpertise(rs.getString("FIELDOFEXPERTISE"));
			expert.setIsGp(rs.getString("ISGP"));
			expert.setIsAlertchain(rs.getString("ISALERTCHAIN"));
			expert.setIsCollaboration(rs.getString("ISCOLLABORATION"));
			expert.setIsAnnotation(rs.getString("ISANNOTATION"));

			return expert;
		}
	}

	@Override
	public void updateExpert(String expertId, String isAnnotation) {
		String SQL = "UPDATE EXPERTS SET ISANNOTATION = :isAnnotation WHERE EXPERTID = :expertId";
		Map<String, Object> params = new HashMap<>();
		params.put("isAnnotation", isAnnotation);
		params.put("expertId", expertId);

		jdbcTemplate.update(SQL, params);

	}

}
