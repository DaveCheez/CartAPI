package com.fusionarc.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fusionarc.cart.entity.Product;
import com.fusionarc.cart.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	private ProductService service;
	
	@Autowired
	public ProductController(ProductService service) {
		this.service = service;
	}
	
	// Create
	@PostMapping("/create")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(this.service.create(product), HttpStatus.CREATED);
	}
	
	// Read All
	@GetMapping("/readAll")
	public ResponseEntity<List<Product>> readAllProducts() {
		return new ResponseEntity<List<Product>>(this.service.readAll(), HttpStatus.OK);
	}
	
	// Read By Id
	@GetMapping("/readById/{id}")
	public ResponseEntity<Product> readById(@PathVariable long id) {
		return new ResponseEntity<Product>(this.service.readById(id), HttpStatus.OK);
	}
	
	// Update
	@PutMapping("/update/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product product) {
		return new ResponseEntity<Product>(this.service.update(id, product), HttpStatus.ACCEPTED);
	}
	
	// Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable long id) {
		return (this.service.delete(id)) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
