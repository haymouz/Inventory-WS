package com.inventory.category;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepo categoryRepo;
	
	@Override
	public String addCategory(Category category) {
		categoryRepo.save(category);
		return "Category Added";
	}

	@Override
	public Category editCategory(Long id, Category category) {

		Category editCat = categoryRepo.getOne(id);
		
		editCat.setName(category.getName());
		editCat.setActive(category.getActive());
		editCat.setCatDetails(category.getCatDetails());
		editCat.setDateModified(LocalDate.now());
		
		return categoryRepo.save(editCat);
	}

	@Override
	public String deleteCategory(Long id) {
		categoryRepo.deleteById(id);
		return "Category Deleted";
	}

	@Override
	public List<Category> getAllCategory() {
		
		return categoryRepo.findAll();
	}
	
	@Override
	public Category getCategory(Long id) {

		return categoryRepo.getOne(id);
	}
}
