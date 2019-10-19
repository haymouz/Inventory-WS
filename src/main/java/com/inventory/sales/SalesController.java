package com.inventory.sales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalesController {
	@Autowired
	SalesServiceImpl salesServiceImpl;
	
//	Add New Sales
	@PostMapping("/addSalesRec")
	public String addSales(@RequestBody List<Sales> sales){
		System.out.println("VAL PASSED "+sales);
		return salesServiceImpl.recordSales(sales);
	}
	
//	Edit sales
//	@PostMapping("/editSales/{id}")
//	public Sales editSales(@PathVariable("id") Long id, @RequestBody Sales sales){
//		
//		return salesServiceImpl.eitSales(id, sales);
//	}
	
//	Get all sales
	@GetMapping("/getAllSales")
	public List<Sales> getAllSales(){
		
		return salesServiceImpl.getAllSalesRec();
	}
	
//	Get sales using id
	@GetMapping("/getSales/{id}")
	public Sales getSales(@PathVariable("id") Long id){

		return salesServiceImpl.getSalesRec(id);
	}

}
