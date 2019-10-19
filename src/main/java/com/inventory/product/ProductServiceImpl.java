package com.inventory.product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.sales.Sales;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo productRepo;
	
	@Override
	public String createProduct(List<Product> productRec) {

		for (Product product : productRec) {		
			productRepo.save(product);
		}
		return "Product Added";
	}

	@Override
	public Product editProduct(Long id, Product product) {

		Product editPrd = productRepo.getOne(id);
		
		editPrd.setName(product.getName());
		editPrd.setPrdSuplier(product.getPrdSuplier());
		editPrd.setPrdUnit(product.getPrdUnit());
		editPrd.setPrdLowStock(product.getPrdLowStock());
		editPrd.setPrdImg(product.getPrdImg());
		editPrd.setPrdPrice(product.getPrdPrice());
		editPrd.setPrdCode(product.getPrdCode());
		editPrd.setPrdDetails(product.getPrdDetails());
		editPrd.setPrdUnitAvail(product.getPrdUnitAvail());
		editPrd.setPrdCategory(product.getPrdCategory());
		editPrd.setDateModified(LocalDate.now());
		
		return productRepo.save(editPrd);
	}

	@Override
	public String deleteProduct(Long id) {
		productRepo.deleteById(id);
		return "Category Deleted";
	}

	@Override
	public List<Product> getAllProduct() {
		
		return productRepo.findAll();
	}

	@Override
	public Product getProduct(Long id) {

		return productRepo.getOne(id);
	}

	@Override
	public List<String> LowStockChecker() {
		
		List<Product> stockChecker = productRepo.findAll();
		
		ArrayList<String> stock = new ArrayList<String>();
		
		for (Product product : stockChecker) {
			if(product.getPrdUnitAvail()<= product.getPrdLimit()) {
				stock.add(product.getName());
			}
		}
		System.out.println(stock);
		return stock;
	}

	@Override
	public Product addStock(Long id, Long qty) {
		Product addstock = productRepo.getOne(id);
		Long update = addstock.getPrdUnitAvail() + qty;
		addstock.setPrdUnitAvail(update);
		
		return productRepo.save(addstock);
	}
		
}
