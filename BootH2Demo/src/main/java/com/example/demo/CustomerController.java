package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepo repo;
	
	
	@RequestMapping("/customers")
	public List<Customer> getAllCustomers()
	{
		return repo.findAll();
	}
	
	
	@RequestMapping("/addCust")
	public ModelAndView addCustomer(Customer cust)
	{
		repo.save(cust);
		
		ModelAndView mv=new ModelAndView("home.jsp");
		return mv;
		
	}
	
	@RequestMapping("/customers/{id}")
	public String getCust(@PathVariable int id)
	{
		return repo.findById(id).toString();
		//return "found";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Customer addCust(Customer cust)
	{
		return repo.save(cust);
	}
	
	

}
