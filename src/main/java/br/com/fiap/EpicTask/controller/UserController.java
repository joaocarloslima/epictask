package br.com.fiap.EpicTask.controller;

import java.sql.SQLException;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.EpicTask.exception.UserNotFoundException;
import br.com.fiap.EpicTask.model.User;
import br.com.fiap.EpicTask.repository.UserRepository;
import br.com.fiap.EpicTask.security.DevSecurityConfiguration;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private MessageSource messageSource;

	@GetMapping()
	@Cacheable(value = "users")
	public ModelAndView user(
			@PageableDefault(size=4, sort="name") Pageable pageable) throws SQLException {
		Page<User> users = repository.findAll(pageable);
		ModelAndView modelAndView = new ModelAndView("users");
		
		//if (users.getSize() < 100) throw new SQLException("erro de sql");
		
		String sort = users.getSort().stream()
			.map(order -> order.getProperty() + "," + order.getDirection())
			.collect(Collectors.joining(","));
		modelAndView.addObject("users", users);
		modelAndView.addObject("sort", sort);
		return modelAndView;
	}
	
	@RequestMapping("new")
	public String formNew(User user){
		return "user_new";
	}
	
	@PostMapping()
	@CacheEvict(value = "users", allEntries = true)
	public String save(@Valid User user, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) return "user_new";
		user.setPass(DevSecurityConfiguration.passwordEncoder().encode(user.getPass()));
		repository.save(user);
		redirect.addFlashAttribute("message", getMessage("message.newuser.success"));
		return "redirect:/user";
	}
	
	@GetMapping("/delete/{id}")
	@CacheEvict(value = "users", allEntries = true)
	
	public String deleteUser(@PathVariable Long id, RedirectAttributes redirect) {
		repository.deleteById(id);
		redirect.addFlashAttribute("message", getMessage("message.deleteuser.success"));
		return "redirect:/user";
	}
	
	@GetMapping("/{id}")
	public ModelAndView editUserForm(@PathVariable Long id) {
		Optional<User> user = repository.findById(id);
		if (user.isEmpty()) throw new UserNotFoundException();
		ModelAndView modelAndView = new ModelAndView("user_edit");
		modelAndView.addObject("user", user);
		return modelAndView;		
	}
	
	@PostMapping("/update")
	@CacheEvict(value = "users", allEntries = true)
	public String updateUser(@Valid User user, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) return "user_edit";
		repository.save(user);
		redirect.addFlashAttribute("message", getMessage("message.edituser.success"));
		return "redirect:/user"; 
	}
	
	private String getMessage(String code) {
		return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
	}
	


}
