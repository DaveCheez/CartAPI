package com.fusionarc.cart.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ProductTest {
	
	// Test Default Constructor
	@Test
	public void testEquals() {
		EqualsVerifier.forClass(Product.class).usingGetClass().verify();
	}
	
	@Test
	public void noIdConstructorTest() {
		Product prod = new Product("Bread", "White Loaf", 1.25, true);
		
		// Check for a value
		assertNotNull(prod.getId());
		assertNotNull(prod.getTitle());
		assertNotNull(prod.getDescription());
		assertNotNull(prod.getPrice());
		assertNotNull(prod.isInStock());
		
		// Check for the correct value
		assertEquals(prod.getId(), 0);
		assertEquals(prod.getTitle(), "Bread");
		assertEquals(prod.getDescription(), "White Loaf");
		assertEquals(prod.getPrice(), 1.25);
		assertEquals(prod.isInStock(), true);
	}
	
	
	@Test
	public void allArgsConstructorTest() {
		Product product = new Product(1, "Bread", "White Loaf", 1.25, true);
		
		// Check for a value
		assertNotNull(product.getId());
		assertNotNull(product.getTitle());
		assertNotNull(product.getDescription());
		assertNotNull(product.getPrice());
		assertNotNull(product.isInStock());
		
		// Check for the correct value
		assertEquals(product.getId(), 1);
		assertEquals(product.getTitle(), "Bread");
		assertEquals(product.getDescription(), "White Loaf");
		assertEquals(product.getPrice(), 1.25);
		assertEquals(product.isInStock(), true);
	}
	
	// Test Getters & Setters
	@Test
	public void getAndSetTest() {
		
		Product productOne = new Product();
		
		// Set Values
		productOne.setId(1);
		productOne.setTitle("Milk");
		productOne.setDescription("Whole Milk, 4 pints");
		productOne.setPrice(1.30);
		productOne.setInStock(true);
		
		// Check for a value
		assertNotNull(productOne.getId());
		assertNotNull(productOne.getTitle());
		assertNotNull(productOne.getDescription());
		assertNotNull(productOne.getPrice());
		assertNotNull(productOne.isInStock());
		
		// Check for the correct value
		assertEquals(productOne.getId(), 1);
		assertEquals(productOne.getTitle(), "Milk");
		assertEquals(productOne.getDescription(), "Whole Milk, 4 pints");
		assertEquals(productOne.getPrice(), 1.30);
		assertEquals(productOne.isInStock(), true);
	}
	
	@Test
	public void toStringTest() {
		Product prod = new Product("Bread", "White Loaf", 1.25, true);
		assertEquals(prod.toString(), "Product\n\tid: 0\n\ttitle: Bread\n\tdescription: White Loaf\n\tprice: £1.25\n\tIn Stock: true");
		
	}

}
