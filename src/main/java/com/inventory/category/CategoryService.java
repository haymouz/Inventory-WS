package com.inventory.category;

import java.util.List;

public interface CategoryService {
	
	public String addCategory(Category category);
	
	public Category editCategory(Long id, Category category);

	public String deleteCategory(Long id);

	public List <Category> getAllCategory();

	public Category getCategory(Long id);

}
