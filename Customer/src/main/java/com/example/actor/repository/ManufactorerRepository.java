package com.example.actor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.actor.entity.Manufactorer;

@Repository
public interface ManufactorerRepository extends JpaRepository<Manufactorer, Integer> {

    Boolean existsByManufactorerName(String manufactorerName);
	
	Manufactorer findByManufactorerName(String manufactorerName);
	
}
