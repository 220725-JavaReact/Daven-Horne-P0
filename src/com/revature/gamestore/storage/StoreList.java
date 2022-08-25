package com.revature.gamestore.storage;

import com.revature.gamestore.models.Store;

public class StoreList {
	private Store[] backingArray;
	private int lastIndex;
	
	public StoreList() {
		backingArray = new Store[1];
		lastIndex = 0;
	}
	
	public void add(Store newStore)
	{
		if(lastIndex == backingArray.length) {
			int newSize = (int) (lastIndex * 1.5);
			Store[] newBacking = new Store[newSize];
			System.arraycopy(backingArray, 0, newBacking, 0, backingArray.length);
			backingArray=newBacking;
		}
		backingArray[lastIndex] = newStore;
		lastIndex++;
	}
	public Store[] getAllElements() {
		return backingArray;
	}
}
