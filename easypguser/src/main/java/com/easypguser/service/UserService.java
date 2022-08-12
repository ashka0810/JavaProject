package com.easypguser.service;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.easypguser.model.User;

public interface UserService {

	int addUser(User user);

	long updateUser(User user);

	int deleteUser(long userId);

	public User getAllDetails(long userId);

}
