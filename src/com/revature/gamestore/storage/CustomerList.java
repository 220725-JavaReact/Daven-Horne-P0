package com.revature.gamestore.storage;

import com.revature.gamestore.models.Customer;

public class CustomerList {
	private Customer[] backingArray;
	private int lastIndex;
	
	public CustomerList() {
		backingArray = new Customer[2];
		lastIndex = 0;
	}
	
	public void add(Customer newCustomer)
	{
		if(lastIndex == backingArray.length) {
			int newSize = (int) (lastIndex * 1.5);
			Customer[] newBacking = new Customer[newSize];
			System.arraycopy(backingArray, 0, newBacking, 0, backingArray.length);
			backingArray=newBacking;
		}
		backingArray[lastIndex] = newCustomer;
		lastIndex++;
	}
	public Customer[] getAllElements() {
		return backingArray;
	}

}
