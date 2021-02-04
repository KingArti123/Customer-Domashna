package com.example.actor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.actor.entity.Category;
import com.example.actor.entity.ResponseByCategory;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Boolean existsByProductCategory(String productCategory);
	
	Category findByProductCategory(String productCategory);
	
	@Query("SELECT c FROM Category c WHERE c.productCategory=:category")
	List<ResponseByCategory> findByCategory(String category);
	
}
