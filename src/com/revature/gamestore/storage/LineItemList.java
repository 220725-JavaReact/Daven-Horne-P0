package com.revature.gamestore.storage;

import com.revature.gamestore.models.LineItem;

public class LineItemList {
	private LineItem[] backingArray;
	private int lastIndex;
	
	public LineItemList() {
		backingArray = new LineItem[4];
		lastIndex = 0;
	}
	
	public void add(LineItem newLineItem)
	{
		if(lastIndex == backingArray.length) {
			int newSize = (int) (lastIndex * 1.5);
			LineItem[] newBacking = new LineItem[newSize];
			System.arraycopy(backingArray, 0, newBacking, 0, backingArray.length);
			backingArray=newBacking;
		}
		backingArray[lastIndex] = newLineItem;
		lastIndex++;
	}
	public LineItem[] getAllElements() {
		return backingArray;
	}
}
