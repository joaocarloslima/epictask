package br.com.fiap.EpicTask.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TaskController {

	@RequestMapping("/task")
	public String tasks() {
		return "tasks";
	}
	
}
