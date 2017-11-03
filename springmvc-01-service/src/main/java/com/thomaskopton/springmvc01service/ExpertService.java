package com.thomaskopton.springmvc01service;

import java.util.List;

import com.thomaskopton.springmvc01domain.Expert;

public interface ExpertService {
	
	void updateAllExperts();
	
	List<Expert> getAllExperts();
}
