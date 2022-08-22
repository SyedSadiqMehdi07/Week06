package com.example.demo.controller;

import javax.management.relation.RelationNotFoundException;
import javax.xml.ws.Response;

import org.hibernate.ResourceClosedException;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Customer.Customer;
import com.example.demo.CustomerRepo.CustomerRepository;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/customers")
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	@GetMapping("/customers/{id}")
	public Response<Customer> getCustomerById(@PathVariable(value = "id") Long customerId)
			throws RelationNotFoundException {
		Customer customer = customerRepository.findById(customerId)
				.orElseGet(() -> new ResourceClosedException("customer not found for this id :: " + customerId));
		return Response.ok().body(customer);
	}

	@PostMapping("/customer")
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long customerId,
			@Valid @RequestBody Customer customerDetails) throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("customer not found for this id :: " + customerId));

		customer.setId(customer.getId());
		customer.setName(customer.getName());
		customer.setphoneNo(customer.getphoneNo());
		customer.setAddress(customer.getAddress());
		final Customer updatedCustomer = customerRepository.save(customer);
		return Response.ok(updatedCustomer);
	}

	@DeleteMapping("/customer/{id}")
	public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Long customerId)
			throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + customerId));

		customerRepository.delete(customer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
