package com.revature.gamestore.dl;

public interface DAO<E>{
	void addInstance(E newInstance);
	E[] getAll();
	
//	void updateInstance(E updateInstance);
//	
//	void deleteInstance(E deleteInstance);
		
	}

