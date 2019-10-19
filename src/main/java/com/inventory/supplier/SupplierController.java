package com.inventory.supplier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupplierController {
	@Autowired
	SupplierServiceImpl supplierServiceImpl;
	
	@PostMapping("/addSupplier")
	public String addSupplier(@RequestBody Supplier supplier) {
		
		return supplierServiceImpl.addSupplier(supplier);
	}
	
	@PostMapping("/editSupplier/{id}")
	public Supplier editSupplier(@PathVariable("id") Long id, @RequestBody Supplier supplier){
		
		return supplierServiceImpl.editSupplier(id, supplier);
	}
	
	@GetMapping("/deleteSupplier/{id}")
	public String deleteSupplier(@PathVariable("id") Long id){
		
		return supplierServiceImpl.deleteSupplier(id);
	}

	@GetMapping("/getAllSupplier")
	public List<Supplier> getAllSupplier(){
		
		return supplierServiceImpl.getAllSupplier();
	}
}
