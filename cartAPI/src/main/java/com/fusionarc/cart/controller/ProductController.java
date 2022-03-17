package com.fusionarc.cart.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import com.fusionarc.cart.repo.ProductRepo;
import com.fusionarc.cart.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	private ProductService service;
	
	@Autowired
	ProductRepo repo;
	
	@Autowired
	public ProductController(ProductService service) {
		this.service = service;
	}
	
	// Create
	@PostMapping("/create")
	public ResponseEntity<Product> createProduct(@RequestBody @Valid Product product) {
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
		
		Optional<Product> optionalProduct = this.repo.findById(id);
		
		if  (optionalProduct.isPresent()) {
			return new ResponseEntity<Product>(this.service.readById(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
	
	// Update
	@PutMapping("/update/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody @Valid Product product) {

		Optional<Product> optionalProduct = this.repo.findById(id);
		
		if (optionalProduct.isPresent()) {
			return new ResponseEntity<Product>(this.service.update(id, product), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
	
	// Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable long id) {
		
		Optional<Product> optionalProduct = this.repo.findById(id);
		
		if (!optionalProduct.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			this.service.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
