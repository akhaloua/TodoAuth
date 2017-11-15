package com.asmaa.DAO;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.asmaa.Model.Role;
import com.asmaa.Model.User;

@Repository

public class RoleDAOImpl implements RoleDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}

	
	

	@Override
	public Role findRoleByName(String roleName) {
		System.out.println("rooooooooooole"+roleName);
		getCurrentSession().beginTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Role.class);
		criteria.add(Restrictions.eq("roleName", roleName));		
		Role role= (Role) criteria.uniqueResult();		getCurrentSession().getTransaction().commit();
		System.out.println("rooooooooooole"+role.getId());
		return role;

	}
	
		
}
