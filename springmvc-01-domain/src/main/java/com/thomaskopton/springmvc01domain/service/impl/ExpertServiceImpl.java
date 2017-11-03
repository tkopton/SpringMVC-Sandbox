package com.thomaskopton.springmvc01domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomaskopton.springmvc01domain.Expert;
import com.thomaskopton.springmvc01domain.repository.ExpertRepository;
import com.thomaskopton.springmvc01domain.service.ExpertService;

@Service
public class ExpertServiceImpl implements ExpertService {

	@Autowired
	private ExpertRepository expertRepository;

	@Override
	public void updateAllExperts() {
		List<Expert> allExperts = expertRepository.getAllExperts();

		for (Expert expert : allExperts) {
			if (expert.getIsAnnotation().equalsIgnoreCase("FALSE"))
				expertRepository.updateExpert(expert.getExpertId(), "TRUE");
		}
	}

	@Override
	public List<Expert> getAllExperts() {
		return expertRepository.getAllExperts();
	}

}
