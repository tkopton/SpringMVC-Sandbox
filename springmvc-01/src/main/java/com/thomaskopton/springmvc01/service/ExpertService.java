package com.thomaskopton.springmvc01.service;

import java.util.List;

import com.thomaskopton.springmvc01.domain.Expert;

public interface ExpertService {
	
	void updateAllExperts();
	
	List<Expert> getAllExperts();
}
