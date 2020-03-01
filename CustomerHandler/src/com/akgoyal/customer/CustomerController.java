package com.akgoyal.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		List<Customer> customers = customerService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		modelAndView.addObject("customers", customers);
		return modelAndView;
	}
	
	@RequestMapping("/new")
	public ModelAndView newCustomer() {
		Customer customer = new Customer();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("new_customer");
		modelAndView.addObject("customer", customer);
		return modelAndView;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.save(customer);
		return "redirect:/";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editCustomer(@RequestParam int id) {
		Customer customer = customerService.findById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("edit_customer");
		modelAndView.addObject("customer", customer);
		return modelAndView;
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam int id) {
		customerService.delete(id);
		return "redirect:/";
	}

}
