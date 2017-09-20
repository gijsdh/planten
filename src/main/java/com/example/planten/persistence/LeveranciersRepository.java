package com.example.planten.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.planten.domain.BestelRegelsId;
import com.example.planten.domain.Leveranciers;

public interface LeveranciersRepository extends CrudRepository<Leveranciers, Long> {

	List<Leveranciers> findById(long id);
}
