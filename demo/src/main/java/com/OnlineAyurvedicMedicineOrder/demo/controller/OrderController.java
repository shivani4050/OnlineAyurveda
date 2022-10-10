package com.OnlineAyurvedicMedicineOrder.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineAyurvedicMedicineOrder.demo.entity.Order;
import com.OnlineAyurvedicMedicineOrder.demo.exception.OrderAlreadyExistsException;
import com.OnlineAyurvedicMedicineOrder.demo.exception.OrderDoesNotExistsException;
import com.OnlineAyurvedicMedicineOrder.demo.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderServ;
	
	@PostMapping("/saveorder")
	public ResponseEntity<Order> save_order(@RequestBody Order order) throws OrderAlreadyExistsException{
		Order savedOrder=orderServ.addOrder(order);
		return new ResponseEntity<Order>(savedOrder,HttpStatus.CREATED);
	}
	
	@GetMapping("getorder/{id}")
	public ResponseEntity<Order> get_Customer(@PathVariable int id) throws OrderDoesNotExistsException{
		Order order=orderServ.viewOrder(id);
		return new ResponseEntity<Order>(order,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteorder/{id}")
	public ResponseEntity<Order> delete_Customer(@PathVariable int id) throws OrderDoesNotExistsException{
		Order order=orderServ.cancelOrder(id);
		return new ResponseEntity<Order>(order,HttpStatus.OK);
	}
	
	@PutMapping("/updateorder")
	public ResponseEntity<Order> update_order(@RequestBody Order order){
		Order savedOrder=orderServ.updateOrder(order);
		return new ResponseEntity<Order>(savedOrder,HttpStatus.CREATED);
	}
	@GetMapping("/allorders")
	public ResponseEntity<List<Order>> getAllOrders(){
		List<Order> orders=orderServ.showAllOrders();
		return new ResponseEntity<List<Order>>(orders,HttpStatus.OK);
	}
	
}
