package com.inventory.product;

import java.util.List;

public interface ProductService {
	
	public Product addStock(Long id, Long qty);

	public String createProduct(List<Product> product);
	
	public Product editProduct(Long id, Product product);

	public String deleteProduct(Long id);

	public List <Product> getAllProduct();
	
	public Product getProduct(Long id);
	
	public List<String> LowStockChecker();
}
