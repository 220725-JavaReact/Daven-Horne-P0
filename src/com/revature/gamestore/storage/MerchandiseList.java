package com.revature.gamestore.storage;

import com.revature.gamestore.models.Merchandise;

public class MerchandiseList {
	private Merchandise[] backingArray;
	private int lastIndex;
	
	public MerchandiseList() {
		backingArray = new Merchandise[10];
		lastIndex = 0;
	}
	
	public void add(Merchandise newMerchandise)
	{
		if(lastIndex == backingArray.length) {
			int newSize = (int) (lastIndex * 1.5);
			Merchandise[] newBacking = new Merchandise[newSize];
			System.arraycopy(backingArray, 0, newBacking, 0, backingArray.length);
			backingArray=newBacking;
		}
		backingArray[lastIndex] = newMerchandise;
		lastIndex++;
	}
	public Merchandise[] getAllElements() {
		return backingArray;
	}
}
