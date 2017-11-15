package com.asmaa.todo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.asmaa.Model.Todo;
import com.asmaa.todo.service.TodoServiceImpl;

@RestController
public class TodoRestController {
	/*
	@Autowired
	private TodoServiceImpl service;

	@RequestMapping(value = "/todo/", method = RequestMethod.GET)
	public List<Todo> listAllTodos() {
		List<Todo> users = service.retrieveTodos("asmaa");
		return users;
	}
	/*
	@RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)

	public Todo retrieveTodo(@PathVariable("id") int id) {
		return service.retrieveTodo(id);
	}
*/
}