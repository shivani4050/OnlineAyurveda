package com.OnlineAyurvedicMedicineOrder.demo.service;

import java.util.List;

import com.OnlineAyurvedicMedicineOrder.demo.entity.User;
import com.OnlineAyurvedicMedicineOrder.demo.exception.IdNotFoundToDelete;
import com.OnlineAyurvedicMedicineOrder.demo.exception.UserAlreadyExistException;


public interface UserService {
	User saveUser(User user) throws UserAlreadyExistException;
	User changeUser(User user);
	List<User> getAllUser();
	User delUserById(int id) throws IdNotFoundToDelete;
	boolean isValidateUser(User user);
}
