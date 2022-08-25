package com.revature.gamestore.models;

public class Order {
	private int orderId;
	private int storeId;
	private int customerId;
	private int productsOrderedId;
	private double totalprice;
	
	//fields for order class
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getProductsOrderedId() {
		return productsOrderedId;
	}
	public void setProductsOrderedId(int productsOrderedId) {
		this.productsOrderedId = productsOrderedId;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	//constructor
	public Order(int orderId, int storeId, int customerId, int productsOrderedId, double totalprice) {
		super();
		this.orderId = orderId;
		this.storeId = storeId;
		this.customerId = customerId;
		this.productsOrderedId = productsOrderedId;
		this.totalprice = totalprice;
	}
	public Order(int storeId, int customerId, int productsOrderedId, double totalprice) {
		super();
		this.storeId = storeId;
		this.customerId = customerId;
		this.productsOrderedId = productsOrderedId;
		this.totalprice = totalprice;
	}
	
}
