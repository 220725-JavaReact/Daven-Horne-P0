package com.revature.gamestore.storage;

import com.revature.gamestore.models.Console;

public class ConsoleList {

	private Console[] backingArray;
	private int lastIndex;
	
	public ConsoleList() {
		backingArray = new Console[6];
		lastIndex = 0;
	}
	
	public void add(Console newConsole)
	{
		if(lastIndex == backingArray.length) {
			int newSize = (int) (lastIndex * 1.5);
			Console[] newBacking = new Console[newSize];
			System.arraycopy(backingArray, 0, newBacking, 0, backingArray.length);
			backingArray=newBacking;
		}
		backingArray[lastIndex] = newConsole;
		lastIndex++;
	}
	public Console[] getAllElements() {
		return backingArray;
	}

}

