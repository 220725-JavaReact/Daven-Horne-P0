package com.revature.gamestore.models;

import java.util.ArrayList;

public class Store {
	//fields
	private String name;
	private String address;
	private  int storeId;
	ArrayList<Merchandise> inventory = new ArrayList<Merchandise>();
	



	ArrayList<Merchandise> Cart = new ArrayList<Merchandise>();
	


	public void createInventory() {
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
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	
	

	//constructor
public Store(int id, String name, String address) {
		super();
		this.storeId = id;
		this.name = name;
		this.address = address;
	}

//	public Store(String name, String city, String state, ArrayList<Merchandise> inventory) {
//		super();
//		this.name = name;
//		City = city;
//		State = state;
//		this.inventory = inventory;
//	}

//	@Override
//	public String toString() {
//		return "Store [name=" + name + ", City=" + City + ", State=" + State + ", inventory=" + inventory + "]";
//	}

   // order method
	public ArrayList<Merchandise> getInventory() {
		return inventory;
	}


	public void setInventory(ArrayList<Merchandise> inventory) {
		this.inventory = inventory;
	}


//	public ArrayList<Merchandise> getCart() {
//		return Cart;
//	}


	public void setCart(ArrayList<Merchandise> cart) {
		Cart = cart;
	}


	public int getStoreId() {
		return storeId;
	}
	//get index 
	public Merchandise getMerchandise(int index) {
		return inventory.get(index);
	}
	//get name of merchandise at index
	public int merchandiseExists(String name) {
		for(int i=0; i<inventory.size(); i++) {
			if(inventory.get(i).getName().equals(name)) {
				return i;
			}
		} return -1;
	}
	public void setMerchandise(int index, Merchandise item) {
		inventory.set(index, item);
	}
}

