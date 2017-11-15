package com.asmaa.todo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asmaa.DAO.UserDAO;
import com.asmaa.Model.Role;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	
	private UserDAO userDao;
	@Autowired
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	 @Autowired
	    private PasswordEncoder passwordEncoder;
	public UserDetailsServiceImpl() {
		super();
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
				com.asmaa.Model.User myUser = userDao.findUserByName(username); //our own User model class
		
		if(myUser!=null){
									
			//populate user roles
			Collection<GrantedAuthority> authoritiesList = new ArrayList<GrantedAuthority>();
			for(Role role : myUser.getRoles()){
				authoritiesList.add(new SimpleGrantedAuthority(role.getRoleName()));
			}
						// create Spring Security User object
			UserDetails userDetails = new User(myUser.getUserName(), myUser.getPassword(),authoritiesList);// springframework.security.core.userdetails.user
			
			return userDetails;
		}else{
			throw new UsernameNotFoundException("User Not Found!!!");
		}
	}

	
}
