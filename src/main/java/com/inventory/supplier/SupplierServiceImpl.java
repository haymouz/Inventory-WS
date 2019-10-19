package com.inventory.supplier;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	SupplierRepo supplierRepo;
	
	@Override
	public String addSupplier(Supplier supplier) {
		supplierRepo.save(supplier);
		return "Supplier Added";
	}

	@Override
	public Supplier editSupplier(Long id, Supplier supplier) {

		Supplier editSup = supplierRepo.getOne(id);
		
		editSup.setName(supplier.getName());
		editSup.setSupplierCode(supplier.getSupplierCode());
		editSup.setSupplierWebsite(supplier.getSupplierWebsite());
		editSup.setDateModified(LocalDate.now());
		
		return supplierRepo.save(editSup);
	}

	@Override
	public String deleteSupplier(Long id) {
		supplierRepo.deleteById(id);
		return "Category Deleted";
	}

	@Override
	public List<Supplier> getAllSupplier() {
		
		return supplierRepo.findAll();
	}
		
}
