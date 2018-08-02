package com.springdemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdemo.entity.Customer;
import com.springdemo.services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService serviceImpl;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		//get customer from the dao
		List<Customer> list = serviceImpl.getCustomers();
		//add customer to model 
		model.addAttribute("customer", list);
		return "listCustomer";
	}
	@GetMapping("/addCustomerForm")
	public String addCustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return"customerForm";
	}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer temp) {
		serviceImpl.save(temp);
		return "redirect:/customer/list";
	}
	@GetMapping("/updateForm")
	public String showUpdateForm(@RequestParam(value="customerId") int id, Model model) {
		Customer temp= serviceImpl.getCustomer(id);
		model.addAttribute("customer", temp);
		return "customerForm";
	}
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam(value="customerId") int id) {
		serviceImpl.deleteCusotmer(id);
		return "redirect:/customer/list";
	}

}
