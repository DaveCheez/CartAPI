package com.fusionarc.cart.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fusionarc.cart.entity.Product;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, 
	scripts = { "classpath:product-schema.sql", "classpath:product-data.sql" })
public class ProductIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper obj; 
	
	//Test Create
	@Test
	public void testCreate() throws Exception {
		
		Product milk = new Product("Milk", "Whole Milk, 4 pints", 1.30, true);
		String milkAsJSON = this.obj.writeValueAsString(milk);
		
		RequestBuilder req = post("/product/create").content(milkAsJSON).contentType(MediaType.APPLICATION_JSON);
		
		Product savedProduct = new Product(2, "Milk", "Whole Milk, 4 pints", 1.30, true);
		String savedProductAsJSON = this.obj.writeValueAsString(savedProduct);
		
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(savedProductAsJSON);
		
		mvc.perform(req).andExpect(checkBody).andExpect(checkStatus);
	}
	
	
	// Test Read All
	@Test
	public void testReadAll() throws Exception {
		
		RequestBuilder req = get("/product/readAll");
		
		ResultMatcher checkStatus = status().isOk();
		
		Product productOne = new Product(1, "Bread", "White Loaf", 1.25, true);
		List<Product> savedList = new ArrayList<>();
		savedList.add(productOne);
		
		String savedListAsJSON = this.obj.writeValueAsString(savedList);
		
		ResultMatcher checkBody = content().json(savedListAsJSON);
		
		mvc.perform(req).andExpect(checkBody).andExpect(checkStatus);
		
	}
	
	// Test Read By Id	
	@Test
	public void testReadById() throws Exception {
		
		RequestBuilder req = get("/product/readById/1");
		
		ResultMatcher checkStatus = status().isOk();
		
		Product productOne = new Product(1, "Bread", "White Loaf", 1.25, true);
		String productOneAsJSON = this.obj.writeValueAsString(productOne);
		
		ResultMatcher checkBody = content().json(productOneAsJSON);
		
		mvc.perform(req).andExpect(checkBody).andExpect(checkStatus);
		
	}
	
	// Test Update
	@Test
	public void testUpdate() throws Exception {
					
		Product milk = new Product(1, "Milk", "Whole Milk, 4 pints", 1.30, true);
		String milkAsJSON = this.obj.writeValueAsString(milk);
		
		RequestBuilder req = put("/product/update/1").content(milkAsJSON).contentType(MediaType.APPLICATION_JSON);
		
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(milkAsJSON);
		
		mvc.perform(req).andExpect(checkBody).andExpect(checkStatus);
		
	}
	
	// Test Delete
	@Test
	public void testDelete() throws Exception {
		RequestBuilder req = delete("/product/delete/1");
		
		ResultMatcher checkStatus = status().isNoContent();
		
		this.mvc.perform(req).andExpect(checkStatus);
		
	}
 }
