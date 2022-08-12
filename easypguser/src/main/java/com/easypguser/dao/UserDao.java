package com.easypguser.dao;

import com.easypguser.model.User;

public interface UserDao extends GenericDAO<User> {
	User loginCheck(User user);

	int emailCheck(User user);

}
