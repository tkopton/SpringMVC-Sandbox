package com.thomaskopton.springmvc01domain.repository;

import java.util.List;

import com.thomaskopton.springmvc01domain.Expert;

public interface ExpertRepository {
	
	List <Expert> getAllExperts();

	void updateExpert(String expertId, String isAnnotation);

}
