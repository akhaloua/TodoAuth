package com.asmaa.DAO;

import java.util.List;

import com.asmaa.Model.Todo;

public interface TodoDAO {

	   List<Todo> retrieveTodos(String user);
	   public void addTodo(Todo todo);
	   public void updateTodo(Todo todo);
	   	public void deleteTodo(int id);
	   	public Todo findTodo(int id);
}
