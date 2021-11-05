package ch.zli.m223.crm.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.zli.m223.crm.model.Customer;
import ch.zli.m223.crm.service.CustomerService;

@Controller
@RequestMapping("/web/customers")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("")
	public String getAllCustomers(Model model) {
		List<Customer> customers = customerService.getAllCustomers();
		model.addAttribute("customers", customers);
		return "customerList";
	}
	
	@GetMapping("/{id}")
	public String getOneCustomerById(@PathVariable("id") long id, Model model) {
		Customer customer = customerService.getCustomerById(id);
		model.addAttribute("customer", customer);
		return "customer";
	}
	
	@GetMapping("/{id}/delete")
	public String deleteCustomer(@PathVariable("id") long id, Model model) {
		customerService.deleteById(id);
		return getAllCustomers(model);
	}
}
