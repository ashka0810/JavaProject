package com.easypg.serviceimpl;

import java.io.File;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.easypg.model.Property;
import com.easypg.model.User;
import com.easypg.dao.PropertyDao;
import com.easypg.dao.UserDao;
import com.easypg.service.PropertyService;

@Service("propertyservice")
@Transactional
@SessionAttributes("user")
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	PropertyDao propertyDao;

	@Autowired
	HttpSession session;

	@Autowired
	UserDao userdao;

	public int deleteProperty(long id) {
		Property property = propertyDao.getById(Property.class, id);
		if (property != null) {
			property.setIsDeleted(1);
			propertyDao.updateObject(property);
		}
		return 0;
	}

	public List<Property> getAll() {

		List<Property> propertyList = propertyDao.getActive();
		return propertyList;
	}

	public Property getById(long id) {
		Property property = propertyDao.getById(Property.class, id);
		return property;
	}

	public List<Property> getPropertiesByUserId(long userId) {
		return propertyDao.getPropertiesByUserId(userId);
	}

}
