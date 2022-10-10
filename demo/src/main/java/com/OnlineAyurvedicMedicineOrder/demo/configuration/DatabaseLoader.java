package com.OnlineAyurvedicMedicineOrder.demo.configuration;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.OnlineAyurvedicMedicineOrder.demo.entity.Customer;
import com.OnlineAyurvedicMedicineOrder.demo.entity.User;
import com.OnlineAyurvedicMedicineOrder.demo.repository.CustomerRepository;
import com.OnlineAyurvedicMedicineOrder.demo.repository.UserRepository;

@Configuration
public class DatabaseLoader {
	
	private UserRepository userRepository;
	
	private CustomerRepository customerRepository;
	
	public DatabaseLoader(UserRepository userRepository,CustomerRepository customerRepository) {
		this.userRepository=userRepository;
		this.customerRepository=customerRepository;
	}
	
	@Bean
	public CommandLineRunner initializeDatabase() {
		return args ->{
			User user1 = new User("admin@ayurveda.net","admin123");
			User user2=new User("colinmunro@ayurveda.net","colin123");
			userRepository.saveAll(List.of(user1,user2));
			
			Customer customer1= new Customer("alex@gmail.com","alex123","Alex rawley");
			Customer customer2= new Customer("jane@gmail.com","jane123","Jane foster");
			customerRepository.saveAll(List.of(customer1,customer2));
			
		};
	}
}
