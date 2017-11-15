package com.asmaa.todo.service;
import java.util.Date;
import java.util.List;

import com.asmaa.Model.*;
public interface TodoService {
	public List<Todo> retrieveTodos(String name);
	public void addTodo(Todo todo);
public void updateTodo(Todo todo);
	public Todo findTodo(int id);
	public void deleteTodo(int id);

}
