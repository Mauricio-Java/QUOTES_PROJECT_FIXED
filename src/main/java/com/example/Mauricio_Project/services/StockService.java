package com.example.Mauricio_Project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Mauricio_Project.entities.Stock;
import com.example.Mauricio_Project.repositories.StockRepository;




@Service
public class StockService {
	
	@Autowired
	private StockRepository repository;
	
	public List<Stock>findALL() {
		return repository.findAll();
	}
	public Stock findById(Long Id) {
		Optional<Stock> obj = repository.findById(Id);
		return obj.get();
	}
	
	public Stock insert(Stock obj) {
		return repository.save(obj);
		}

		public void delete(Long id) {
				repository.deleteById(id);
			}
		
		public Stock update(Long id, Stock obj) {
			
			Stock entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		
		}	

	private void updateData(Stock entity, Stock obj) {
		entity.setName(obj.getName());
		entity.setQuotes(obj.getQuotes());
		
	}
	}

