package com.cryptocurrency.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cryptocurrency.backend.services.CurrencyServices;
import com.cryptocurrency.entity.objects.Cryptocurrency;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CurrencyController {

	@Autowired
	private CurrencyServices service;

	@GetMapping("/hello-currency")
	public String helloCuurency() {
		return "Hello currency";
	}
	
	@PostMapping("/addCryptocurrency")
	public Cryptocurrency addCryptocurrency(@RequestBody Cryptocurrency Cryptocurrency) {
		return service.saveCryptocurrency(Cryptocurrency);
	}

	@PostMapping("/addCryptocurrencys")
	public List<Cryptocurrency> addCryptocurrencys(@RequestBody List<Cryptocurrency> Cryptocurrencys) {
		return service.saveCryptocurrencyList(Cryptocurrencys);
	}

	@GetMapping("/list")
	public List<Cryptocurrency> findAllCryptocurrencys() {
		return service.getCryptocurrencyList();
	}
	
	@GetMapping("/Cryptocurrency/{id}")
	public Cryptocurrency findCryptocurrencyById(@PathVariable Integer id) {
		return service.getCryptocurrencyById(id);
	}
	
//	@GetMapping("/Cryptocurrencyname/{name}")
//	public Cryptocurrency updateCryptocurrency (@PathVariable String name) {
//		return service.getCryptocurrencyFirstName(name);
//	}
	
//	@PutMapping("/update")
//		public Cryptocurrency updateCryptocurrency(@RequestBody Cryptocurrency Cryptocurrency) {
//		return service.updateCryptocurrencyName(Cryptocurrency);
//	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteCryptocurrency(Integer id) {
		return service.deleteCryptocurrency(id);
		
	}
	
}