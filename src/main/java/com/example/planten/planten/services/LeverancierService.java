package com.example.planten.planten.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.planten.domain.Bestelling;
import com.example.planten.domain.Leveranciers;
import com.example.planten.persistence.LeveranciersRepository;

@Service
@Transactional
public class LeverancierService {
	
	
	@Autowired
	private LeveranciersRepository leveranciersRepository;
	
	
	public Iterable<Leveranciers> findAll(){
		System.out.println("here");
		return leveranciersRepository.findAll();
	}
	
	public Iterable<Leveranciers> findSet(Long id){
		
		return leveranciersRepository.findById(id);
	}
	
	
}
