package com.cryptocurrency.backend.entities.cryptocurrencies;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


// One to many on the dynamics fields
// One to One on the static fields
// 


@Entity
@Table(name = "currency_daily_price")
public class CryptocurrencyDailyPrice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "symbol")
	private String symbol;

	
	// US Dollars
	@Column(name = "price")
	private String price;

	@Column(name = "price_date")
	private String priceDate;

	@Column(name = "price_timestamp")
	private String priceTimeStamp;
	// Price * Circulating Supply = Market Cap
	@Column(name = "circulating_supply")
	private String circulatingSupply;

	@Column(name = "max_supply")
	private String maxSupply;
	// Market Cap = Price * Circulating Supply
	@Column(name = "market_cap")
	private String marketCap;

	@Column(name = "high")
	private String high;

	@Column(name = "high_timestamp")
	private String highTimeStamp;

	public CryptocurrencyDailyPrice() {}

	public CryptocurrencyDailyPrice(
							  String symbol,
							  String price,
							  String priceDate,
							  String priceTimeStamp,
							  String circulatingSupply,
							  String maxSupply,
							  String marketCap,
							  String high,
							  String highTimeStamp
							  )
	{
		this.symbol = symbol;
		this.price = price;
		this.priceDate = priceDate;
		this.priceTimeStamp = priceTimeStamp;
		this.circulatingSupply = circulatingSupply;
		this.maxSupply = maxSupply;
		this.marketCap = marketCap;
		this.high = high;
		this.highTimeStamp = highTimeStamp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPriceDate() {
		return priceDate;
	}

	public void setPriceDate(String priceDate) {
		this.priceDate = priceDate;
	}

	public String getPriceTimeStamp() {
		return priceTimeStamp;
	}

	public void setPriceTimeStamp(String priceTimeStamp) {
		this.priceTimeStamp = priceTimeStamp;
	}

	public String getCirculatingSupply() {
		return circulatingSupply;
	}

	public void setCirculatingSupply(String circulatingSupply) {
		this.circulatingSupply = circulatingSupply;
	}

	public String getMaxSupply() {
		return maxSupply;
	}

	public void setMaxSupply(String maxSupply) {
		this.maxSupply = maxSupply;
	}

	public String getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(String marketCap) {
		this.marketCap = marketCap;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getHighTimeStamp() {
		return highTimeStamp;
	}

	public void setHighTimeStamp(String highTimeStamp) {
		this.highTimeStamp = highTimeStamp;
	}
}
