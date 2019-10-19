package com.inventory.sales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.product.Product;
import com.inventory.product.ProductRepo;

@Service
public class SalesServiceImpl implements SalesService {

	@Autowired
	SalesRepo salesRepo;

	@Autowired
	ProductRepo productRepo;

//	@Override
//	public Sales editSalesRec(Long id, Sales sales) {

//		Sales editPrd = salesRepo.getOne(id);
//		
//		editPrd.setName(sales.getName());
//		editPrd.setPrdSuplier(sales.getPrdSuplier());
//		editPrd.setPrdUnit(sales.getPrdUnit());
//		editPrd.setPrdLowStock(sales.getPrdLowStock());
//		editPrd.setPrdImg(sales.getPrdImg());
//		editPrd.setPrdPrice(sales.getPrdPrice());
//		editPrd.setPrdCode(sales.getPrdCode());
//		editPrd.setPrdDetails(sales.getPrdDetails());
//		editPrd.setPrdUnitAvail(sales.getPrdUnitAvail());
//		editPrd.setPrdCategory(sales.getPrdCategory());
//		editPrd.setDateModified(LocalDate.now());
//		
//		return salesRepo.save(editPrd);
//	}

	@Override
	public String deleteSalesRec(Long id) {
		salesRepo.deleteById(id);
		return "Category Deleted";
	}

	@Override
	public List<Sales> getAllSalesRec() {
		
		return salesRepo.findAll();
	}

	@Override
	public Sales getSalesRec(Long id) {

		return salesRepo.getOne(id);
	}


	double price=0;
	@Override
	public String recordSales(List<Sales> salesRecs) {
		Long availItem;
		
		for (Sales sales : salesRecs) {
			System.out.println("I got here "+ sales.getItemCode());
			Product getProd = productRepo.findByPrdCode(Long.parseLong(sales.getItemCode()));
System.out.println("ZAINAB "+getProd.getPrdCategory());
			availItem = getProd.getPrdUnitAvail();
			if (availItem < Long.parseLong(sales.getQuantity())) {
				return getProd.getName() + " Item is out of Stock";
			}

			Long update = availItem - Long.parseLong(sales.getQuantity());
			getProd.setPrdUnitAvail(update);
			price = price + getProd.getPrdPrice() * Long.parseLong(sales.getQuantity());
			salesRepo.save(sales);

		}
		return "Sales Recorded, Total Amount is: "+ price;
	}

}
