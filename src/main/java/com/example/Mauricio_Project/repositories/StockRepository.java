package com.example.Mauricio_Project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Mauricio_Project.entities.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
	
	

}
