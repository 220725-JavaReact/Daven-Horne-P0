package com.revature.gamestore.storelogic;

import java.util.ArrayList;

import com.revature.gamestore.models.Merchandise;

public class Storelogic {
	ArrayList<Merchandise> inventory = new ArrayList<Merchandise>();
	
	
	ArrayList<Merchandise> Cart = new ArrayList<Merchandise>();
	public static void createInventory() {
		ArrayList<Merchandise> inventory = new ArrayList<Merchandise>();
		inventory.add(new Merchandise("Nintendo Switch", 199.99, 3));
		inventory.add(new Merchandise("PlayStation 4", 249.99, 2));
		inventory.add(new Merchandise("PlayStation 5", 459.99, 6));
		inventory.add(new Merchandise("Xbox One", 149.99, 2));
		inventory.add(new Merchandise("Xbox X", 500.00, 2));
		inventory.add(new Merchandise("Xbox S", 463.00, 10));
		inventory.add(new Merchandise("Pokemon Shield", 59.99, 8));
		inventory.add(new Merchandise("Super Smash Bros. Ultimate", 59.99, 6));
		inventory.add(new Merchandise("Final Fantasy XV", 59.99, 7));
		inventory.add(new Merchandise("Grand Theft Auto V", 59.99, 5));

	}


}
