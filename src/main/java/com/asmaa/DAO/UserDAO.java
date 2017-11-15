package com.asmaa.DAO;

import java.util.List;

import com.asmaa.Model.User;

public interface UserDAO {

	       void addUser(User user);
	    void editUser(User user);
	   	 void deleteuser(int id);
	   	User findUserByEmail(String email);
	   	 User findUserByName(String username);
List<User> getAllUsers();


}
