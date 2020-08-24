package br.com.fiap.EpicTask.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.EpicTask.model.User;
import br.com.fiap.EpicTask.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository repository;

	@GetMapping()  
	public String users() {
		return "users";
	}
	
	@PostMapping()  
	public String save(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "user_new";
		}
		repository.save(user);
		return "redirect:user";
	}
	
	@RequestMapping("new")  
	public String formUser(User user) {
		return "user_new";
	}
	
}
