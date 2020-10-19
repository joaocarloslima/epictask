package br.com.fiap.EpicTask.controller;

import java.sql.SQLException;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.EpicTask.exception.UserNotFoundException;
import br.com.fiap.EpicTask.model.User;
import br.com.fiap.EpicTask.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository repository;

	@GetMapping()  
	@Cacheable("users")
	public ModelAndView users(@PageableDefault(page = 0, size = 4) Pageable pageable) throws SQLException {
		Page<User> users = repository.findAll(pageable);
		
		if (users.getSize() < 100) throw new SQLException("table not exist");
		
		String sort = users.getSort().stream()
							.map(order -> order.getProperty() + "," + order.getDirection())
							.collect(Collectors.joining(","));
		
		ModelAndView modelAndView = new ModelAndView("users");
		modelAndView.addObject("users", users);
		modelAndView.addObject("sort", sort);
		return modelAndView;
	}
	
	@PostMapping()  
	public String save(@Valid User user, BindingResult result, RedirectAttributes attribute) {
		if (result.hasErrors()) return "user_new";
		user.setPass(new BCryptPasswordEncoder().encode(user.getPass()));
		repository.save(user);
		attribute.addFlashAttribute("message", "usuário cadastrado com sucesso");
		return "redirect:user";
	}
	
	@RequestMapping("/new")  
	public String formUser(User user) {
		return "user_new";
	}
	
	@CacheEvict(value = "users", allEntries = true)
	@RequestMapping("delete/{id}")
	public String deleteUser(@PathVariable Long id, RedirectAttributes attributes) {
		repository.deleteById(id);
		attributes.addFlashAttribute("message", "usuário apagado com sucesso");
		return "redirect:/user";
	}
	
	@GetMapping("{id}")
	public ModelAndView editForm(@PathVariable Long id) {
		Optional<User> user = repository.findById(id);
		if (user.isEmpty()) throw new UserNotFoundException();
		ModelAndView modelAndView = new ModelAndView("user_edit");
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	
	@PostMapping("update")
	public String updateUser(@Valid User user, BindingResult result){
		if (result.hasErrors()) return "user_edit";
		repository.save(user);
		return "redirect:/user";
	}
	

	
	
	
	
	
	
	
	
	
}
