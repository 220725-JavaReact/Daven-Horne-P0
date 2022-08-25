package com.revature.gamestore.storage;

import com.revature.gamestore.models.Game;

public class GameList {
	private Game[] backingArray;
	private int lastIndex;
	
	public GameList() {
		backingArray = new Game[8];
		lastIndex = 0;
	}
	
	public void add(Game newGame)
	{
		if(lastIndex == backingArray.length) {
			int newSize = (int) (lastIndex * 1.5);
			Game[] newBacking = new Game[newSize];
			System.arraycopy(backingArray, 0, newBacking, 0, backingArray.length);
			backingArray=newBacking;
		}
		backingArray[lastIndex] = newGame;
		lastIndex++;
	}
	public Game[] getAllElements() {
		return backingArray;
	}

}
