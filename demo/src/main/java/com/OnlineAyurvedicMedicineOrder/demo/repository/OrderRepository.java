package com.OnlineAyurvedicMedicineOrder.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.OnlineAyurvedicMedicineOrder.demo.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	
}
