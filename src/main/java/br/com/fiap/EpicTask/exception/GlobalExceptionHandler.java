package br.com.fiap.EpicTask.exception;

import java.security.Principal;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;


@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
	@ExceptionHandler({SQLException.class, DataAccessException.class})
	public ModelAndView handleErrorDatabase(Exception ex, HttpServletRequest req, Principal user) {
		log.error("Erro: " + ex.getMessage() 
		+ " url: " + req.getRequestURL() 
		+ " user: " + user.getName());
		
		ModelAndView modelAndView = new ModelAndView("database_error");
		modelAndView.addObject("error", ex.getClass());
		modelAndView.addObject("message", ex.getMessage());
		return modelAndView;
	}
	
}
