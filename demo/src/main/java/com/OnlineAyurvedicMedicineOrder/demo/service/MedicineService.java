package com.OnlineAyurvedicMedicineOrder.demo.service;

import java.util.List;
import java.util.Optional;

import com.OnlineAyurvedicMedicineOrder.demo.entity.Medicine;

public interface MedicineService {
	Medicine addMedicine(Medicine medicine);
	Optional<Medicine> viewMedicine(int id);
	Medicine updateMedicine(Medicine medicine) throws Exception;
	void deleteMedicine(int id);
	List<Medicine> showAllMedicine();
	
}
