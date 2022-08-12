package com.easypg.serviceimpl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.easypg.dao.AdminDao;
import com.easypg.model.Admin;
import com.easypg.service.LoginService;

@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService{

	@Autowired
	AdminDao adminDao;

	@Autowired
	HttpSession session;
	
	public Admin login(Admin admin) {
		String password = admin.getPassword();
		admin.setPassword(password);
		return adminDao.loginCheck(admin);
	}
	
}
