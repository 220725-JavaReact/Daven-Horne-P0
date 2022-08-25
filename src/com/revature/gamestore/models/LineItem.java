package com.revature.gamestore.models;

public class LineItem {
 private int itemId;
 private int orderId;
 private double price;
 private int quantity;
public int getItemId() {
	return itemId;
}
public void setItemId(int itemId) {
	this.itemId = itemId;
}
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
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
public LineItem(int itemId, int orderId, double price, int quantity) {
	super();
	this.itemId = itemId;
	this.orderId = orderId;
	this.price = price;
	this.quantity = quantity;
}
 
}
