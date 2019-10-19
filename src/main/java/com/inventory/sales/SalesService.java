package com.inventory.sales;

import java.util.List;

public interface SalesService {
	
	public String recordSales(List<Sales> sales);
	
//	public Sales editSalesRec(Long id, Sales sales);

	public String deleteSalesRec(Long id);

	public List <Sales> getAllSalesRec();
	
	public Sales getSalesRec(Long id);
	
}
