package com.fusionarc.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Manual Testing the toString method
// import com.fusionarc.cart.entity.Product;

@SpringBootApplication
public class CartApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartApiApplication.class, args);
		
//		System.out.println(optionalProduct);
		// Manual Testing the toString method
		//	Product productOne = new Product(1, "Bread", "White Loaf", 1.25, true);
		//	System.out.println(productOne);
	}

}
