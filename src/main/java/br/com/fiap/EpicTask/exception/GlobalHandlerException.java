package br.com.fiap.EpicTask.exception;

import java.security.Principal;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalHandlerException {
	
	@ExceptionHandler({SQLException.class, DataAccessException.class})
	public ModelAndView handleDatabaseError(Exception ex, HttpServletRequest req, Principal user) {
		Logger log = LoggerFactory.getLogger(GlobalHandlerException.class);
		log.error("Erro= " + ex.getClass() + 
				" url= " + req.getRequestURL() +
				" user= " + user.getName());
		ModelAndView modelAndView = new ModelAndView("database_error");
		modelAndView.addObject("error", ex.getClass());
		modelAndView.addObject("message", ex.getMessage());
		
		return modelAndView;
	}
	
	
	
}
