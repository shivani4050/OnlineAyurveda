package com.OnlineAyurvedicMedicineOrder.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OnlineAyurvedicMedicineOrder.demo.entity.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine,Integer>{
	
	//List<Medicine> findAllByCategory_Id(int categoryId);
}
