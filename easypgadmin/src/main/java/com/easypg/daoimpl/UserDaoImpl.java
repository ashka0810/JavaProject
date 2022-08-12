package com.easypg.daoimpl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.easypg.dao.UserDao;
import com.easypg.model.User;
import com.easypg.model.User;

@Repository("userDao")
@SessionAttributes("user")
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	
	@Autowired
	HttpSession session;
	public User saveupdateUser(User user) {
		return super.saveUpdateObject(user);
	}
	
	public User loginCheck(User user) {
		String query = "FROM User where email='" + user.getEmail() + "' and password='" + user.getPassword() + "'";
		List<User> list = super.getByQuery(query);
		if (list.size() == 0) {
			return null;
		}
		return list.get(0);

	}
	public int emailCheck(User user) {
		String query = "FROM User where email='"+user.getEmail()+"'";
		List<User> list = super.getByQuery(query);
		return list.size();
	}

	public List<User> getActive() {
		return (List<User>) super.getByQuery("FROM User a WHERE a.isDeleted=0");
	}

	public List<User> getLandlords() {
		return (List<User>) super.getByQuery("FROM User a WHERE a.isLandlord=1 and a.isDeleted=0");
	}

	public List<User> getTenants() {
		return (List<User>) super.getByQuery("FROM User a WHERE a.isLandlord=0 and a.isDeleted=0");
	}
}
