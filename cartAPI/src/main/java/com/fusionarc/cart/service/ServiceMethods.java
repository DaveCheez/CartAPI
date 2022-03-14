package com.fusionarc.cart.service;

import java.util.List;

public interface ServiceMethods<T> {
	
	// Create Method
	T create(T product);
	
	// Read All Method
	List<T> readAll();
	
	// Read by Id Method
	T readById(long id);
	
	// Update Method
	T update(long id, T product);
	
	// Delete Method
	boolean delete(long id);

}
