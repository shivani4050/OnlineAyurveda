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

import com.OnlineAyurvedicMedicineOrder.demo.entity.User;
import com.OnlineAyurvedicMedicineOrder.demo.exception.IdNotFoundToDelete;
import com.OnlineAyurvedicMedicineOrder.demo.exception.UserAlreadyExistException;
import com.OnlineAyurvedicMedicineOrder.demo.service.UserService;



@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<User> addUser(@RequestBody User user) throws UserAlreadyExistException{
		if(userService.isValidateUser(user)) {
		User savedUser = userService.saveUser(user);
		return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<User>(user,HttpStatus.EXPECTATION_FAILED);
		}
	}
	@PutMapping("/user/update")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		if(userService.isValidateUser(user)) {
		User changedUser = userService.changeUser(user);
		return new ResponseEntity<User>(changedUser,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<User>(user,HttpStatus.EXPECTATION_FAILED);
		}
	}
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUser(){
		List<User> allUsers = userService.getAllUser();
		return new ResponseEntity<List<User>>(allUsers,HttpStatus.OK);	
	}
	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable int id) throws IdNotFoundToDelete{
		User delUser = userService.delUserById(id);
		return new ResponseEntity<User>(delUser,HttpStatus.OK);
	}
	
	
}
