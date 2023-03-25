package com.examserver.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examserver.model.User;
import com.examserver.repo.RoleRepo;
import com.examserver.repo.UserRepo;
import com.examserver.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RoleRepo roleRepo;

	@Override

	// creating user
	public User createUser(User user) throws Exception {

		//User local = this.userRepo.findByUserName(user.getUserName());
		User local =this.userRepo.save(user);
//
//		if (local != null) {
//			System.out.println("user is already there");
//
//			throw new Exception("user already present");
//		}
//
//		else
//
//		// user create
//		{
//			for (UserRole ur : userRoles) {
//				roleRepo.save(ur.getRole());
//			}
//		}
//		user.getUserRoles().addAll(userRoles);
//		local = this.userRepo.save(user);
//
		return local;
	}

	@Override
	public List<User> getUserName(String userName) {
		
		return this.userRepo.findByUserName(userName);
		 
	}

	@Override
	public List<User> deleteUser(Long id) {
		this.userRepo.deleteById(id);
		return userRepo.findAll();
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	

//	@Override
//	public  List<User> updateUserById(Long id,User user) {
//		
//	 userRepo.save(user);
//		return getAllUsers();
//
//	}

	
	public User updateUser(User user) {
		Long id = user.getId();
		User u= userRepo.findById(id).get();
		u.setUserName(user.getUserName());
		u.setPassword(user.getPassword());
		u.setFirstName(user.getFirstName());
		u.setLastName(user.getLastName());
		u.setEmail(user.getEmail());
		u.setPhone(user.getPhone());
		return userRepo.save(u);
	}




	

}
