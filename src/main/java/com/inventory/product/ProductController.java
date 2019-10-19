package com.inventory.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	ProductServiceImpl productServiceImpl;
	
//	Add New Product
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody List<Product> product) {
		
		return productServiceImpl.createProduct(product);
	}
	
//	Edit product
	@PostMapping("/editProduct/{id}")
	public Product editProduct(@PathVariable("id") Long id, @RequestBody Product product){
		
		return productServiceImpl.editProduct(id, product);
	}
	
//	Delete Product
	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable("id") Long id){
		
		return productServiceImpl.deleteProduct(id);
	}

//	Get all products
	@GetMapping("/getAllProduct")
	public List<Product> getAllProduct(){
		
		return productServiceImpl.getAllProduct();
	}
	
//	Get product using id
	@GetMapping("/getProduct/{id}")
	public Product getProduct(@PathVariable("id") Long id){

		return productServiceImpl.getProduct(id);
	}
	
//	Check Product Stock  
	@GetMapping("/LowStockChecker")
	public List<String> LowStockChecker(){

		return productServiceImpl.LowStockChecker();
	}
	
}
