package com.asmaa.todo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asmaa.DAO.TodoDAO;
import com.asmaa.DAO.TodoDAOImpl;
import com.asmaa.Model.*;
@Service
//@Transactional
public class TodoServiceImpl implements TodoService {
	@Autowired	
	TodoDAO todoDAO;
	
	public void setTodoDAO(TodoDAO todoDAO) {
		this.todoDAO = todoDAO;
	}
	//@Transactional(propagation=Propagation.REQUIRED)	
	public List<Todo> retrieveTodos(String user) {
		
		return this.todoDAO.retrieveTodos(user);
	}
//	@Transactional(propagation=Propagation.REQUIRED)
	public void addTodo(Todo todo) {
		todoDAO.addTodo(todo);
		}
	//@Transactional(propagation=Propagation.REQUIRED)
	public Todo findTodo(int id) {
		
		return todoDAO.findTodo(id);
	}
//	@Transactional(propagation=Propagation.REQUIRED)
public void updateTodo(Todo todo)
{
	todoDAO.updateTodo(todo);
	
	
}
//@Transactional(propagation=Propagation.REQUIRED)
	public void deleteTodo(int id) {
	todoDAO.deleteTodo(id);
	}
	
	
}
