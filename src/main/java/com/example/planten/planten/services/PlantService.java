package com.example.planten.planten.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.planten.domain.Plant;
import com.example.planten.persistence.PlantRepository;

@Service
@Transactional
public class PlantService {
	@Autowired
	private PlantRepository plantenRepository;
	
	public Plant save(Plant planten) {
		return plantenRepository.save(planten);
	}

	public Iterable<Plant> findAll() {

		Iterable <Plant> result = plantenRepository.findAll();
		return result;
	}
	
	/**
	 * Retrieves one Plant from the database with specified id. If the id
	 * does not exist, null is returned 
	 * @param id the id of the Question
	 * @return requested Question or null if it does not exist
	 */
	public Plant findById(long id) {
		return this.plantenRepository.findOne(id);
	}
}
