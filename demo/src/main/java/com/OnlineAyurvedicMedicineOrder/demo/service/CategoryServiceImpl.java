package com.OnlineAyurvedicMedicineOrder.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineAyurvedicMedicineOrder.demo.entity.Category;
import com.OnlineAyurvedicMedicineOrder.demo.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}
	
	@Override
	public List<Category> getAllCategories(){
		return categoryRepository.findAll();
	}
	@Override
	public void removeCategoryById(int id){ 
		categoryRepository.deleteById(id);
	}
	
	@Override
	public Optional<Category> getCategoryById(int id) {
		return categoryRepository.findById(id);
	}
	
}
