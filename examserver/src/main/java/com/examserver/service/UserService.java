package com.examserver.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.examserver.model.User;
import com.examserver.model.UserRole;



public interface UserService {
	
	//creating user
	
	public User createUser(User user ) throws Exception;
	

	//get user by username
	
	public List<User> getUserName(String username);
	
	//get All User
	
	public List<User> getAllUsers();
	
	
	//delete user
	
	public List<User> deleteUser(Long id);


	//public List<User> updateUserById(Long id,User user);
	
	public User updateUser(User user);



	
	
}


