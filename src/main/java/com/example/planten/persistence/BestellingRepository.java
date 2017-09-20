package com.example.planten.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.planten.domain.Bestelling;
import com.example.planten.domain.Leveranciers;

public interface BestellingRepository extends CrudRepository<Bestelling, Long> {
	
	List<Bestelling> findByLeverancierLevnaam(String LeverancierLevnaam);
	Bestelling findById(Integer id);

	
}	
