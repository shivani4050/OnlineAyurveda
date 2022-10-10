package com.OnlineAyurvedicMedicineOrder.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OnlineAyurvedicMedicineOrder.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByEmail(String email);
}
