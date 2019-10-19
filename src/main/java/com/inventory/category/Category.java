package com.inventory.category;

import javax.persistence.Entity;

import com.inventory.commonFields.CommonFields;

@Entity(name="category")
public class Category extends CommonFields{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String active;
	
	private String catDetails;
	
	public String getActive() {
		return active;
	}
	
	public void setActive(String active) {
		this.active = active;
	}
	
	public String getCatDetails() {
		return catDetails;
	}
	
	public void setCatDetails(String catDetails) {
		this.catDetails = catDetails;
	}
	
	@Override
	public String toString() {
		return "Category [active=" + active + ", catDetails=" + catDetails + "]";
	}
}
