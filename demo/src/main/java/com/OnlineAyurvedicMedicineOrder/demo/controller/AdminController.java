package com.OnlineAyurvedicMedicineOrder.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineAyurvedicMedicineOrder.demo.DataTransferObject.MedicineDTO;
import com.OnlineAyurvedicMedicineOrder.demo.entity.Category;
import com.OnlineAyurvedicMedicineOrder.demo.entity.Medicine;
import com.OnlineAyurvedicMedicineOrder.demo.service.CategoryService;
import com.OnlineAyurvedicMedicineOrder.demo.service.MedicineService;

@RestController
public class AdminController {
	
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private MedicineService medicineService;
	
	@GetMapping("/admin")
	public ResponseEntity<String> adminHome() {
		return new ResponseEntity<String>("Displaying HomePage",HttpStatus.OK);
	}
	
	@GetMapping("/admin/categories")
	public ResponseEntity<List<Category>> getCategories(Model model) {
		//model.addAttribute("categories",categoryService.getAllCategories());
		List<Category> list=categoryService.getAllCategories();
		return new ResponseEntity<List<Category>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/admin/categories/add")
	public ResponseEntity<String> getAddCategories(Model model) {
		model.addAttribute("category", new Category());
		return new ResponseEntity<String>("New Category Added in the model",HttpStatus.OK);
	}
	@PostMapping("/admin/categories/add")
	public ResponseEntity<String> postAddCategories(@RequestBody Category category) {
		categoryService.addCategory(category);
		return new ResponseEntity<String>("Added the category successfully",HttpStatus.CREATED);
	}
	
	@DeleteMapping("/admin/categories/delete/{id}")
	public ResponseEntity<String> deleteCat(@PathVariable int id) {
		categoryService.removeCategoryById(id);
		return new ResponseEntity<String>("Category deleted successfully", HttpStatus.OK);
	}
	
	@PutMapping("/admin/categories/update/{id}")
	public ResponseEntity<String> updateCategries(@PathVariable int id,Model model) {
		Optional<Category> category = categoryService.getCategoryById(id);
		if(category.isPresent()) {
			model.addAttribute("category",category.get());
			return new ResponseEntity<String>("Category updated successfully", HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("No category found",HttpStatus.NOT_FOUND);
	}
	
	//MedicineSection
	
	@GetMapping("/admin/medicines")
	public ResponseEntity<List<Medicine>> getAllMedicines(Model model) {
		//model.addAttribute("medicines", medicineService.showAllMedicine());
		List<Medicine>list=medicineService.showAllMedicine();
		
		return new ResponseEntity<List<Medicine>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/admin/medicines/add")
	public ResponseEntity<String> addMedicineGet(Model model) {
		model.addAttribute("medicineDTO", new MedicineDTO());
		model.addAttribute("categories",categoryService.getAllCategories());
		return new ResponseEntity<String>("Medicine added to the model", HttpStatus.OK);
	}
	
	@PostMapping("/admin/medicines/add")
	public ResponseEntity<String> medicineAddPost(@RequestBody MedicineDTO medicineDTO) {
		
		Medicine medicine=new Medicine();
		medicine.setMedicineId(medicineDTO.getMedicineId());
		medicine.setMedicineName(medicineDTO.getMedicineName());
		medicine.setCategory(categoryService.getCategoryById(medicineDTO.getCategoryId()).get());
		medicine.setCompanyName(medicineDTO.getCompanyName());
		medicine.setExpiryDate(medicineDTO.getExpiryDate());
		medicine.setMedicineCost(medicineDTO.getMedicineCost());
		medicine.setMfd(medicineDTO.getMfd());
		medicineService.addMedicine(medicine);
		return new ResponseEntity<String>("Medicine added successfully",HttpStatus.OK);
	}
	
	@DeleteMapping("/admin/medicines/delete/{id}")
	public ResponseEntity<String> deleteMedicine(@PathVariable int id) {
		medicineService.deleteMedicine(id);
		return new ResponseEntity<String>("Medicine deleted successfully", HttpStatus.OK);
	}
	
	@PutMapping("/admin/medicines/update/{id}")
	public ResponseEntity<String> updateMedicineGet(@PathVariable int id,Model model) {
		Medicine medicine=medicineService.viewMedicine(id).get();
		MedicineDTO medicineDTO=new MedicineDTO();
		medicineDTO.setMedicineId(medicine.getMedicineId());
		medicineDTO.setMedicineName(medicine.getMedicineName());
		medicineDTO.setCategoryId(medicine.getCategory().getCategoryId());
		medicineDTO.setExpiryDate(medicine.getExpiryDate());
		medicineDTO.setMfd(medicine.getMfd());
		medicineDTO.setMedicineCost(medicine.getMedicineCost());
		medicineDTO.setCompanyName(medicine.getCompanyName());
		
		model.addAttribute("categories",categoryService.getAllCategories());
		model.addAttribute("medicineDTO", medicineDTO);
		
		return new ResponseEntity<String>("Medicine Updated successfully", HttpStatus.OK);
	}
	
	
}
