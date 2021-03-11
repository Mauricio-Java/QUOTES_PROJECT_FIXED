package com.example.Mauricio_Project.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.Mauricio_Project.entities.Stock;
import com.example.Mauricio_Project.services.StockService;



@RestController
@RequestMapping(value = "/stocks")

public class StockResource {
	
	@Autowired
	private StockService service;
	
	@GetMapping
	public ResponseEntity<List<Stock>> findALL() {
		
		List<Stock> list = service.findALL();
		return ResponseEntity.ok().body(list);
	}
		
		
		@GetMapping(value = "/{id}")
		public ResponseEntity<Stock> findById(@PathVariable Long id) {
			Stock obj = service.findById(id);
			return ResponseEntity.ok().body(obj);
		
	}
		
		@PostMapping
		public ResponseEntity<Stock> insert(@RequestBody Stock obj){
			
			obj= service.insert(obj);
					//return ResponseEntity.ok().body(obj);   // esta certo mas vamos alterar para vir op codigo 201 ao inves de 200
					
					URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
							.buildAndExpand(obj.getId()).toUri();
					return ResponseEntity.created(uri).body(obj);	
		}
		
		@DeleteMapping(value = "/{id}")
		public ResponseEntity<Void> delete(@PathVariable Long id) {
			service.delete(id);
			return ResponseEntity.noContent().build();
		}
		
		@PutMapping(value = "/{id}")
		public ResponseEntity<Stock> update(@PathVariable Long id, @RequestBody Stock obj) {
			obj = service.update(id, obj);
			return ResponseEntity.ok().body(obj);
		}
		
}
	
	


