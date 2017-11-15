package com.asmaa.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asmaa.Model.Todo;
import com.asmaa.Model.User;

@Repository

public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addUser(User user) {
			
		    	 getCurrentSession().beginTransaction();
			getCurrentSession().save(user);
	
	getCurrentSession().getTransaction().commit();
	
	}

	@Override
	public void editUser(User user) {
		if (user!=null)
			  getCurrentSession().beginTransaction();
		getCurrentSession().update(user);
		getCurrentSession().getTransaction().commit();
		
	}

	@Override
	public void deleteuser(int id) {
		getCurrentSession().beginTransaction();
		 User user =getCurrentSession().get(User.class, id);
	     if (user!=null)
			getCurrentSession().delete(user);
	getCurrentSession().getTransaction().commit();
			
	}
/*
	@Override
	public User findUser(int id) {
		getCurrentSession().beginTransaction();
		User user=(User)getCurrentSession().get(User.class, id);
		getCurrentSession().getTransaction().commit();
		return user;
	}
*/
	@Override
	public User findUserByName(String username) {
				getCurrentSession().beginTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", username));		
		User user= (User) criteria.uniqueResult();		
		getCurrentSession().getTransaction().commit();

		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		getCurrentSession().beginTransaction();
		List<User> users=getCurrentSession().createQuery("from User").list();
		getCurrentSession().getTransaction().commit();
		return users;
	}

	@Override
	public User findUserByEmail(String email) {
		getCurrentSession().beginTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("email", email));		
		User user= (User) criteria.uniqueResult();		getCurrentSession().getTransaction().commit();

		return user;
	}
	
		
}
