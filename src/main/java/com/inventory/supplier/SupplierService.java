package com.inventory.supplier;

import java.util.List;

public interface SupplierService {
	public String addSupplier(Supplier Supplier);
	
	public Supplier editSupplier(Long id, Supplier Supplier);

	public String deleteSupplier(Long id);

	public List <Supplier> getAllSupplier();
}
