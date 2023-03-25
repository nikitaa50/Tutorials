package com.examserver.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examserver.model.Role;
import com.examserver.model.User;
import com.examserver.model.UserRole;
import com.examserver.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserControlller {

	@Autowired
	private UserService userService;

	
	
	//create user 
	
	@PostMapping("/add")
	public User createUser(@RequestBody User user) throws Exception {

	//	Set<UserRole> roles = new HashSet<>();

		//Role role = new Role();

	//	role.setRoleId(54L);
	//	role.setRoleName("normal");

	//	UserRole userRole = new UserRole();

	//	userRole.setUser(user);
	//	userRole.setRole(role);

	//	roles.add(userRole);

		return this.userService.createUser(user);
	}
	
	//get user by username

	@GetMapping("/{username}")
	public List<User> getuser(@PathVariable("username") String Username) {
		return this.userService.getUserName(Username);

		
		
	}
	
	@GetMapping("/")
	public List<User> getAllEmployees(){
		   List<User> employees = new ArrayList<User>();
		   userService.getAllUsers().forEach(employee -> employees.add(employee));
		   return employees;
		}
	
	//delete user by id
	@DeleteMapping("/{id}")
	public List<User> deleteUserByid(@PathVariable("id") Long id)
	{
		return this.userService.deleteUser(id);
	}
	
	//update user
	
//	@PutMapping("/{id}")
//	public List<User> updateUserById(@PathVariable("id") Long id , @RequestBody User user)
//	{
//	return userService.updateUserById(id,user);
//		
//	}
	
	@PutMapping("/")
	public User updateUser(@RequestBody User user) {
		return  userService.updateUser(user);
	}
	
}
