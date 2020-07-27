package com.cryptocurrency.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cryptocurrency.backend.services.CurrencyIntervalServices;
<<<<<<< HEAD
import com.cryptocurrency.nomics.objects.CurrencyInterval;
=======

>>>>>>> Working

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CurrencyIntervalController {

	@Autowired
	private CurrencyIntervalServices currencyIntervalServices;

	// GET: All Currencies
<<<<<<< HEAD
	@GetMapping("/users/{username}/cryptocurrenciesInterval")
	public List<CurrencyInterval> getAllInfo(@PathVariable String username) {
		return currencyIntervalServices.findAll();
	}

//	// GET: Top Ten Currencies
//	@GetMapping("/users/{username}/cryptocurrencies/topTen")
//	public List<CurrencyInfo> getTopTen(@PathVariable String username) {
//		return currencyServices.listTopTen();
//	}
//	// GET: A Currency
	@GetMapping("/users/{username}/cryptocurrenciesInterval/id/{symbol}/{interval}")
	public List<CurrencyInterval> getByCurrencyId(@PathVariable String username, @PathVariable String symbol, @PathVariable String interval) {
		return currencyIntervalServices.currencyDayInterval(symbol,interval);
	}
//	
//	// GET: A Currency
//	@GetMapping("/users/{username}/cryptocurrencies/{currency}")
//	public CurrencyInfo getByCurrency(@PathVariable String username, @PathVariable String currency) {
//		return currencyServices.findByAnyCurrency(currency);
//	}
=======
	//@GetMapping("/users/{username}/cryptocurrenciesInfo")
//	public List<CurrencyInfo> getAllInfo(@PathVariable String username) {
//		return currencyIntervalServices.findAll();
	//}

>>>>>>> Working
}
