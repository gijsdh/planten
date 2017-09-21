package com.example.planten.planten.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.planten.domain.Bestelling;
import com.example.planten.domain.Bestelregels;
import com.example.planten.domain.Leveranciers;
import com.example.planten.persistence.BestellingRepository;


@Service
@Transactional
public class BestellingService {
	
	
	@Autowired
	private BestellingRepository bestellingRepository;
	

	
	public Iterable<Bestelling> findAll(){
		return bestellingRepository.findAll();
	}
	
    public Iterable<Bestelling> findByLeveranciersNaam(String naam){
		
		return bestellingRepository.findByLeverancierLevnaam(naam);
	}
	
    
    public Bestelling findByid(Integer id){

 		Bestelling temp = bestellingRepository.findById(id);

 		
 		return temp;
 		
 	}
    
   public Iterable<Bestelregels> findByidBestelregels(Integer id){
//	   System.out.println("TESTEN");
		Bestelling temp = bestellingRepository.findById(id);
//		System.out.print("Bestelling: ");
//		System.out.println(temp);
//		System.out.print("Besteregels: ");
//		System.out.println(temp.getBestelregels() == null);
		
		return temp.getBestelregels();
		
	}
    
   
   public void saveChange(Bestelling bestelling) {
	   
	   bestellingRepository.save(bestelling);
	   
   }

}
