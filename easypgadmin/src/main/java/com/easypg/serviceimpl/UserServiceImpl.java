package com.easypg.serviceimpl;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.easypg.model.Area;
import com.easypg.model.User;

import com.easypg.dao.AreaDao;
import com.easypg.dao.UserDao;
import com.easypg.service.UserService;

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

	public long addUser(User user) {
		User ad = (User) session.getAttribute("user");
		user.setIsActive(1);
		user.setPassword("Root@123");
		User a = userDao.saveObject(user);
		return 0;
	}

	public User editUser(int id) {
		return null;
	}

	public int deleteUser(int id) {
		User user = userDao.getById(User.class, id);
		if (user != null) {
			user.setIsDeleted(1);
			userDao.updateObject(user);
		}
		return 0;
	}

	public List<User> getAll() {
		List<User> userList = userDao.getActive();
		return userList;
	}

	public int updateUser(User user) {
		User oldad = userDao.getById(User.class, user.getUserId());
		User ad = (User) session.getAttribute("user");
		userDao.updateObject(user);

		return 0;
	}

	public User getById(long id) {
		User user = userDao.getById(User.class, id);
		return user;
	}

	public List<User> getAllLandlords() {

		List<User> userList = userDao.getLandlords();
		return userList;
	}

	public List<User> getAllTenants() {
		List<User> userList = userDao.getTenants();
		return userList;
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
