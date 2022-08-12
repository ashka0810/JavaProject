package com.easypguser.serviceimpl;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.easypguser.model.Area;
import com.easypguser.model.User;

import com.easypguser.dao.AreaDao;
import com.easypguser.dao.UserDao;
import com.easypguser.service.UserService;
@Service("userservice")
@Transactional
@SessionAttributes("user")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	HttpSession session;

	@Autowired
	AreaDao areadao;


	public int addUser(User user) {
		String password = user.getPassword();
		User ud = (User) session.getAttribute("user");
		user.setIsActive(1);
		int result = userDao.emailCheck(user);
		if (result != 0) {
			return 1;
		}
		user.setPassword(user.getCpassword());
		User a = userDao.saveObject(user);
		return 0;
	}

	public int editUser(User user) {
		userDao.updateObject(user);

		return 0;
	}

	public int deleteUser(long userId) {
		User user = userDao.getById(User.class, userId);
		if (user != null) {
			user.setIsDeleted(1);
			userDao.updateObject(user);
		}
		return 0;
	}

	public long updateUser(User user) {
		User oldad = userDao.getById(User.class, user.getUserId());
		User ad = (User) session.getAttribute("user");
		User u1 = userDao.updateObject(user);
		return u1.getUserId();
	}

	public User getAllDetails(long userId) {
		User u = userDao.getById(User.class, userId);
		Area a = areadao.getAllDetails(u.getAreaId());
		u.setStateId(a.getStateId());
		u.setStateName(a.getSname());
		u.setCity_id(a.getCity_id());
		u.setCity_name(a.getCname());
		u.setAreaName(a.getName());
		return u;
	}

}
