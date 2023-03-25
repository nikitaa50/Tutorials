package com.examserver.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examserver.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
	
	public List<User> findByUserName(String userName);
}
