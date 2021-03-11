package com.example.Mauricio_Project.config;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.Mauricio_Project.entities.Stock;
import com.example.Mauricio_Project.repositories.StockRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private StockRepository stockRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		Stock s1 = new Stock();
		s1.setName("PETROS");
		 double[] quotes = new double[5];
		 quotes[0]=10.0;
		 quotes[1]=12.0;
		 quotes[2]=13.0;
		 quotes[3]=14.0;
		 quotes[4]=15.0;
		s1.setQuotes(quotes);
		
		Stock s2 = new Stock();
		s2.setName("BB");
	//	 double[] quotes = new double[5];
		 quotes[0]=231.0;
		 quotes[1]=579.0;
		 quotes[2]=13.0;
		 quotes[3]=14.0;
		 quotes[4]=832.0;
		s2.setQuotes(quotes);
		



	stockRepository.saveAll(Arrays.asList(s1,s2));
	

}
}
