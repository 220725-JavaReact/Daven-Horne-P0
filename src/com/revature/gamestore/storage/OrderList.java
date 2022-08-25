package com.revature.gamestore.storage;

import com.revature.gamestore.models.Order;

public class OrderList {
	private Order[] backingArray;
	private int lastIndex;
	
	public OrderList() {
		backingArray = new Order[10];
		lastIndex = 0;
	}
	
	public void add(Order newOrder)
	{
		if(lastIndex == backingArray.length) {
			int newSize = (int) (lastIndex * 1.5);
			Order[] newBacking = new Order[newSize];
			System.arraycopy(backingArray, 0, newBacking, 0, backingArray.length);
			backingArray=newBacking;
		}
		backingArray[lastIndex] = newOrder;
		lastIndex++;
	}
	public Order[] getAllElements() {
		return backingArray;
	}
}
