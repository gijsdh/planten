package com.example.planten.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.planten.domain.Plant;

@Component
public interface PlantRepository extends CrudRepository<Plant, Integer> {

}
