package com.asmaa.DAO;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.asmaa.Model.Todo;

@Repository

public class TodoDAOImpl implements TodoDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
		
@SuppressWarnings("unchecked")
@Override
		public  List<Todo> retrieveTodos(String user) {
	try
	{
		getCurrentSession().beginTransaction();
	List<Todo> mytodoList=getCurrentSession().createQuery("from Todo where user='"+user+"'").list();
	getCurrentSession().getTransaction().commit();
	return mytodoList;
	}
	finally
	{
	//	sessionFactory.close();
	}
					

}
@Override
public  Todo findTodo(int id) {
	try
	{
		getCurrentSession().beginTransaction();
	Todo myTodo=getCurrentSession().get(Todo.class, id);
	getCurrentSession().getTransaction().commit();
	return myTodo;
	}
	finally
	{
		//sessionFactory.close();
	}
			
}

@Override
public void addTodo(Todo todo) {
	
		try
		{
			getCurrentSession().beginTransaction();
						getCurrentSession().save(todo);
		getCurrentSession().getTransaction().commit();
			
		}
		finally
		{
		//	sessionFactory.close();
		}
	
	
}


@Override
public void updateTodo(Todo todo) {
  if (todo!=null)
	  getCurrentSession().beginTransaction();
getCurrentSession().update(todo);
getCurrentSession().getTransaction().commit();

	
}


@Override
public void deleteTodo(int id) {
	try
	{
		getCurrentSession().beginTransaction();
		 Todo todo =getCurrentSession().get(Todo.class, id);
	     if (todo!=null)
			getCurrentSession().delete(todo);
	getCurrentSession().getTransaction().commit();
	
	}
	finally
	{
	//	sessionFactory.close();
	}
	
	
}

}
