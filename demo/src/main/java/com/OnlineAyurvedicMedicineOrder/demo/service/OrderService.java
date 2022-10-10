package com.OnlineAyurvedicMedicineOrder.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.OnlineAyurvedicMedicineOrder.demo.entity.Order;
import com.OnlineAyurvedicMedicineOrder.demo.exception.OrderAlreadyExistsException;
import com.OnlineAyurvedicMedicineOrder.demo.exception.OrderDoesNotExistsException;


public interface OrderService {
	Order addOrder(Order order) throws OrderAlreadyExistsException;
	Order viewOrder(int id) throws OrderDoesNotExistsException;
	Order updateOrder(Order order);
	Order cancelOrder(int id) throws OrderDoesNotExistsException;
	List<Order> showAllOrders();
}
