package com.easypguser.serviceimpl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.easypguser.dao.UserDao;
import com.easypguser.model.User;
import com.easypguser.service.LoginService;

@Service("loginService")
@Transactional
@SessionAttributes("user")
public class LoginServiceImpl implements LoginService{

	@Autowired
	UserDao userDao;

	@Autowired
	HttpSession session;
	
	public User login(User user) {
		user.setPassword(user.getPassword());
		return userDao.loginCheck(user);
	}
	


}

	



