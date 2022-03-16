package com.fusionarc.cart.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fusionarc.cart.entity.Product;
import com.fusionarc.cart.repo.ProductRepo;

@SpringBootTest
public class ProductServiceUnitTest {

	@Autowired
	private ProductService service;
	
	@MockBean
	private ProductRepo repo;
	
	@Test
	public void productCreateTest() {
		
		// Input Data
		Product input = new Product("Milk", "Whole Milk, 4 pints", 1.30, true);
		// Expected Output
		Product output = new Product(1, "Milk", "Whole Milk, 4 pints", 1.30, true);
		
		// Testing the create method
		Mockito.when(this.repo.save(input)).thenReturn(output);
		
		// Check expected output is equal to the given output
		assertEquals(output, this.service.create(input));
		
		// Verifies that the repository is run once & the input is saved
		Mockito.verify(this.repo, Mockito.times(1)).save(input);
	}
	
	
	@Test
	public void productReadAllTest() {
		// Input Data
		Product productOne = new Product(1, "Milk", "Whole Milk, 4 pints", 1.30, true);
		// Use a List as it is used in the readAll() method in the ProductService class
		List<Product> productList = new ArrayList<>();
		// Add data to the list
		productList.add(productOne);
		// Check that the type of data that we use is a list
		Mockito.when(this.repo.findAll()).thenReturn(productList);
		
		assertEquals(productList, this.service.readAll());
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	
	@Test
	public void productReadByIdTest() {
		// Input Data
		// Use an optional it is used in the readById() method in the ProductService class
		Optional<Product> optionalOutput = Optional.of(new Product(1, "Milk", "Whole Milk, 4 pints", 1.30, true));
		// Expected Output
		Product output = new Product(1, "Milk", "Whole Milk, 4 pints", 1.30, true);
		
		// Check that the type of data that we use is a long
		Mockito.when(this.repo.findById(Mockito.anyLong())).thenReturn(optionalOutput);
		
		assertEquals(output, this.service.readById(Mockito.anyLong()));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(Mockito.anyLong());
	}
	
	@Test
	public void deleteTrueTest() {
		Mockito.when(this.repo.existsById(1L)).thenReturn(false);
		
		assertTrue(this.service.delete(1L));
		
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(1L);
		Mockito.verify(this.repo, Mockito.times(1)).existsById(1L);
	}
	
	
	
}
