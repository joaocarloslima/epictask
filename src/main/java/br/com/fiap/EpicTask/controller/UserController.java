package br.com.fiap.EpicTask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fiap.EpicTask.model.User;
import br.com.fiap.EpicTask.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository repository;

	@RequestMapping(value="/user", method = RequestMethod.GET)  
	public String users() {
		return "users";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)  
	public String save(User user) {
		System.out.println(user);
		repository.save(user);
		return "redirect:user";
	}
	
	@RequestMapping("/user/new")  
	public String formUser() {
		return "user_new";
	}
	
}
