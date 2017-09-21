package com.example.planten.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.planten.domain.BestelRegelsId;
import com.example.planten.domain.Bestelregels;
import com.example.planten.domain.Leveranciers;

public interface BestelregelRepository extends CrudRepository<Bestelregels, BestelRegelsId>{

	List<Bestelregels> findById(BestelRegelsId id);
	
	@Query("SELECT br FROM Bestelregels br WHERE br.id.bestelRegelId = ?1")
	List<Bestelregels> findByBestellingIdAndId(Integer id);
	

	Bestelregels findBestelregelsBybestellingBestelregelsIdBestelRegelIdAndIdArtcodeID(Integer bestelID, Integer id);//findBestelRegelByBestelling_LevcodeAndBestelnrAndArtcode(Long levcode, Long bestelnr, Long artcode);
	
	
}
