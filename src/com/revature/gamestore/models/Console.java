package com.revature.gamestore.models;

public class Console {
	//fields
	private int productId;
	private String name;
	private double price;
	public enum  brand{
		Nintendo,
		Sony,
		Microsoft
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name){
		this.name = name;
		}
	
	

	public int getProductId() {
		return productId;
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	 // constructor
	public Console(int id, String name, double price, brand[] brands) {
		super();
		this.productId = id;
		this.name = name;
		this.price = price;
		}
	public Console(String name, double price, brand[] brands) {
		super();
		this.name = name;
		this.price = price;
		}

	public Console(int id, String name, double price, brand nintendo) {
		super();
		this.name = name;
		this.price = price;
	}

	//toString method
	@Override
	public String toString() {
		return "Console [name=" + name + ", price=" + price +  "]";
	}





}
