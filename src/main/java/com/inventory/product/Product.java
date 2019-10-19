package com.inventory.product;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.inventory.category.Category;
import com.inventory.commonFields.CommonFields;

@Entity
public class Product extends CommonFields{

	private static final long serialVersionUID = 1L;
	
	private String prdSuplier;
	
	private Long prdUnit;
	
	private Long prdLimit;
	
	private String prdImg;

	private String prdCategory;
	
	private Float prdPrice;
	
	private Long prdCode;
	
	private String prdDetails;
	
	private Long prdUnitAvail;

	private Long prdLowStock;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cat_id", unique = true)
	private Category prdCat;
	
	protected Product() {
	}

	public Product(String prdSuplier, Long prdUnit, Long prdLimit, String prdImg, String prdCategory, Float prdPrice,
			Long prdCode, String prdDetails, Long prdUnitAvail, Long prdLowStock, Category prdCat) {
		this.prdSuplier = prdSuplier;
		this.prdUnit = prdUnit;
		this.prdLimit = prdLimit;
		this.prdImg = prdImg;
		this.prdCategory = prdCategory;
		this.prdPrice = prdPrice;
		this.prdCode = prdCode;
		this.prdDetails = prdDetails;
		this.prdUnitAvail = prdUnitAvail;
		this.prdLowStock = prdLowStock;
		this.prdCat = prdCat;
	}

	public String getPrdSuplier() {
		return prdSuplier;
	}

	public void setPrdSuplier(String prdSuplier) {
		this.prdSuplier = prdSuplier;
	}

	public Long getPrdUnit() {
		return prdUnit;
	}

	public void setPrdUnit(Long prdUnit) {
		this.prdUnit = prdUnit;
	}

	public Long getPrdLimit() {
		return prdLimit;
	}

	public void setPrdLimit(Long prdLimit) {
		this.prdLimit = prdLimit;
	}

	public String getPrdImg() {
		return prdImg;
	}

	public void setPrdImg(String prdImg) {
		this.prdImg = prdImg;
	}

	public String getPrdCategory() {
		return prdCategory;
	}

	public void setPrdCategory(String prdCategory) {
		this.prdCategory = prdCategory;
	}

	public Float getPrdPrice() {
		return prdPrice;
	}

	public void setPrdPrice(Float prdPrice) {
		this.prdPrice = prdPrice;
	}

	public Long getPrdCode() {
		return prdCode;
	}

	public void setPrdCode(Long prdCode) {
		this.prdCode = prdCode;
	}

	public String getPrdDetails() {
		return prdDetails;
	}

	public void setPrdDetails(String prdDetails) {
		this.prdDetails = prdDetails;
	}

	public Long getPrdUnitAvail() {
		return prdUnitAvail;
	}

	public void setPrdUnitAvail(Long prdUnitAvail) {
		this.prdUnitAvail = prdUnitAvail;
	}

	public Long getPrdLowStock() {
		return prdLowStock;
	}

	public void setPrdLowStock(Long prdLowStock) {
		this.prdLowStock = prdLowStock;
	}

	public Category getPrdCat() {
		return prdCat;
	}

	public void setPrdCat(Category prdCat) {
		this.prdCat = prdCat;
	}

	@Override
	public String toString() {
		return "Product [prdSuplier=" + prdSuplier + ", prdUnit=" + prdUnit + ", prdLimit=" + prdLimit + ", prdImg="
				+ prdImg + ", prdCategory=" + prdCategory + ", prdPrice=" + prdPrice + ", prdCode=" + prdCode
				+ ", prdDetails=" + prdDetails + ", prdUnitAvail=" + prdUnitAvail + ", prdLowStock=" + prdLowStock
				+ ", prdCat=" + prdCat + "]";
	}

}
