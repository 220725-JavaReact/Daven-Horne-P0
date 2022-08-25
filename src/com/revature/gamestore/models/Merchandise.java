		package com.revature.gamestore.models;

import java.util.ArrayList;

import com.revature.gamestore.models.Console.brand;
import com.revature.gamestore.models.Game.consoleType;

public class Merchandise {
	private int itemId;
	private int storeId;
	private String name;
	private double price;
	public static enum category {
		Console,
		Game,
	}
	private int quantity;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// constructor
	public Merchandise(String name, double price, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public Merchandise(int id, String name, int storeid, int quantity, category Console) {
		super();
		this.itemId = id;
		this.name = name;
		this.quantity = quantity;
		this.storeId = storeid;
	}
	
	
	//adding  Consoles
	public static ArrayList<Console> createConsoleList() {
		ArrayList<Console> consoles = new ArrayList<>();
		consoles.add(new Console(7,"Nintendo Switch", 199.99, Console.brand.Nintendo));
		consoles.add(new Console(8,"PlayStation 4", 249.99, Console.brand.Sony));
		consoles.add(new Console(9,"PlayStation 5", 459.99, Console.brand.Sony));
		consoles.add(new Console(10,"Xbox One", 149.99, Console.brand.Microsoft));
		consoles.add(new Console(11,"Xbox Series X", 500.00, Console.brand.Microsoft));
		consoles.add(new Console(12,"Xbox Series S", 463.00, Console.brand.Microsoft));
		return consoles;
	}
	
	//adding games
	public static ArrayList<Game> createGameList() {
		ArrayList<Game> games = new ArrayList<>();
		games.add(new Game(1,"Super Smash Bros. Ultimate", Game.consoleType.values(), 59.99, "T", 8));
		games.add(new Game(2,"Pokemon Shield", Game.consoleType.values(), 59.99, "E", 1));
		games.add(new Game(3,"Final Fantasy XV(PS4)", Game.consoleType.values(), 59.99, "T", 1));
		games.add(new Game(4,"Final Fantasy XV(Xbox One)", Game.consoleType.values(), 59.99, "T", 1));
		games.add(new Game(5,"Grand Theft Auto V (PS4)", Game.consoleType.values(), 59.99, "M", 2));
		games.add(new Game(6,"Grand Theft Auto V (Xbox One)", Game.consoleType.values(), 59.99, "M", 2));
		games.add(new Game(13,"Devil May Cry V Special Edition(PS5)", Game.consoleType.values(), 39.99, "M", 3));
		games.add(new Game(13,"Devil May Cry V Special Edition(XSX)", Game.consoleType.values(), 39.99, "M", 3));
		games.add(new Game(13,"Devil May Cry V Special Edition(XSX)", Game.consoleType.values(), 39.99, "M", 3));
		return games;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
}
