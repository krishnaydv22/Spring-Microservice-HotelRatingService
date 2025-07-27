package com.lcwd.user.sevice.services;

import java.util.List;

import com.lcwd.user.sevice.entities.User;

public interface UserService {
	
	public User saveUser(User user);
	
	public List<User> getAllUser();
	
	public User getUser(String userId);
	
	public void deleteUser(String userId);
	
	public User updateUser(String userId, User user);
	
	

}
