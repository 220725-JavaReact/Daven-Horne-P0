package com.revature.gamestore.models;

public class Game {
	//fields
	private int productId;
	private String name;
	private double price;
	private String Rating;
	private int numPlayers;
	public static enum consoleType{
		NintendoSwitch,
		PlayStation4,
		PlayStation5,
		XboxOne,
		XboxSeriesX,
		XboxSeriesS
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getRating() {
		return Rating;
	}

	public void setRating(String rating) {
		Rating = rating;
		
	}

	public int getNumPlayers() {
		return numPlayers;
	}

	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

//public String getConsoleType(consoleType type) {
//	return Game.consoleType = Game.consoleType.valueOf(type);
//}
	//constructor
		public Game(int id, String name, consoleType[] type, double price, String rating, int numPlayers) {
		super();
		this.productId = id;
		this.name = name;
		this.price = price;
		Rating = rating;
		this.numPlayers = numPlayers;
	}
		public Game(int id, String name, double price, String rating, int numPlayers, consoleType type) {
		super();
		this.productId = id;
		this.name = name;
		this.price = price;
		Rating = rating;
		this.numPlayers = numPlayers;
	}
	public Game(String name, double price, String rating, int numPlayers, consoleType[] type) {
		super();
		this.name = name;
		this.price = price;
		Rating = rating;
		this.numPlayers = numPlayers;
	}
	public Game(String name, double price, String rating, int numPlayers, consoleType type) {
		super();
		this.name = name;
		this.price = price;
		Rating = rating;
		this.numPlayers = numPlayers;
	}
	


	@Override
	public String toString() {
		return "Game [name=" + name + ", price=" + price + ", Rating=" + Rating + ", numPlayers=" + numPlayers + "]";
	}



}
