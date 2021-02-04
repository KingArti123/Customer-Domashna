package com.example.actor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.actor.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
	
    

}
