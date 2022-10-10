package com.OnlineAyurvedicMedicineOrder.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineAyurvedicMedicineOrder.demo.entity.Customer;
import com.OnlineAyurvedicMedicineOrder.demo.exception.CustomerAlreadyExistsException;
import com.OnlineAyurvedicMedicineOrder.demo.exception.CustomerDoesNotExistsException;
import com.OnlineAyurvedicMedicineOrder.demo.repository.CustomerRepository;



@Service
public class CustomerServiceImp implements CustomerSercive {

	@Autowired
	private CustomerRepository customerRepo;
	@Override
	public Customer addCustomer(Customer customer) throws CustomerAlreadyExistsException {
		if(customerRepo.existsById(customer.getId()))
			throw new CustomerAlreadyExistsException();
		Customer savedCustomer= customerRepo.save(customer);
		return savedCustomer;
	}

	@Override
	public Customer viewCustomer(int id) throws CustomerDoesNotExistsException {
		if(!customerRepo.existsById(id))
			throw new CustomerDoesNotExistsException();
		Optional<Customer> customer=customerRepo.findById(id);
		return customer.get();
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		if(customerRepo.existsById(customer.getId())) {
			customerRepo.deleteById(customer.getId());
			Customer savedCustomer= customerRepo.save(customer);
			return savedCustomer;
		}
		else {
			Customer savedCustomer= customerRepo.save(customer);
			return savedCustomer;
		}
	}

	@Override
	public Customer deleteCustomer(int id) throws CustomerDoesNotExistsException {
		if(!customerRepo.existsById(id))
			throw new CustomerDoesNotExistsException();
		Optional<Customer> customer=customerRepo.findById(id);
		customerRepo.deleteById(id);
		return customer.get();
	}

	@Override
	public List<Customer> showAllCustomers() {
		List<Customer> customers= customerRepo.findAll();
		return customers;
	}

	
}
