package com.fusionarc.cart.service;

import java.util.List;
import java.util.Optional;

import com.fusionarc.cart.entity.Product;
import com.fusionarc.cart.repo.ProductRepo;

public class ProductService implements ServiceMethods<Product>{
	
	private ProductRepo repo;

	public ProductService(ProductRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Product create(Product product) {
		return this.repo.save(product);
	}

	@Override
	public List<Product> readAll() {
		return this.repo.findAll();
	}

	@Override
	public Product readById(long id) {
		Optional<Product> getProduct = this.repo.findById(id);
		if (getProduct.isPresent()) {
			return getProduct.get();
		}
		return null;
	}

	@Override
	public Product update(long id, Product product) {
		Optional<Product> existing = this.repo.findById(id);
		if (existing.isPresent()) {
			Product exists = existing.get();
			exists.setTitle(product.getTitle());
			exists.setDescription(product.getDescription());
			exists.setPrice(product.getPrice());
			exists.setInStock(product.isInStock());
			
			return this.repo.saveAndFlush(exists);
		}
		return null;
	}

	@Override
	public boolean delete(long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
}
