package com.easypg.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.easypg.model.User;

public interface UserService {
	public long addUser(User user);
	public User editUser(int id);
	public int deleteUser(int id);
	public List<User> getAll();
	public int updateUser(User user);
	public User getById(long l);
	public List<User> getAllLandlords();
	public List<User> getAllTenants();
	public User getAllDetails(long id);
	
}
