package ch.zli.m223.crm.controller.rest.dto;

import java.util.ArrayList;
import java.util.List;

import ch.zli.m223.crm.model.Customer;

public class CustomerDto {
	public long id;
	public String name;
	public String street;
	public String city;
	public List<String> memos = new ArrayList<>();
	
	public CustomerDto(Customer customer) {
		this.id = customer.getId();
		this.name = customer.getName();
		this.street = customer.getStreet();
		this.city = customer.getCity();
		memos.addAll(customer.getMemos());
	}
}
