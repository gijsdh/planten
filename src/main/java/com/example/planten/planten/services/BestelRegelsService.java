package com.example.planten.planten.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.planten.domain.BestelRegelsId;
import com.example.planten.domain.Bestelling;
import com.example.planten.domain.Bestelregels;
import com.example.planten.persistence.BestelregelRepository;

@Service
@Transactional
public class BestelRegelsService {

	
	
	@Autowired
	private BestelregelRepository bestelregelRepository;
	
	
public Iterable<Bestelregels> findByid(BestelRegelsId id){
		
		return bestelregelRepository.findById(id);
	}
	


public Iterable<Bestelregels> findByCustom(Integer id){
	
	return bestelregelRepository.findAll();
}

public void saveNewBestelRegel(Bestelregels bestelregels) {
	   
	bestelregelRepository.save(bestelregels);
	   
}

public Bestelregels findByBothId(Integer bestenummerID, Integer ArtNummerId) {
	   
	return bestelregelRepository.findBestelregelsBybestellingBestelregelsIdBestelRegelIdAndIdArtcodeID(bestenummerID, ArtNummerId);
	   
}




}
