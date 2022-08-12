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
import com.easypguser.model.Property;
import com.easypguser.model.User;
import com.easypguser.dao.AreaDao;
import com.easypguser.dao.PropertyDao;
import com.easypguser.dao.UserDao;
import com.easypguser.service.PropertyService;

@Service("propertyservice")
@Transactional
@SessionAttributes("user")
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	PropertyDao propertyDao;

	@Autowired
	HttpSession session;

	@Autowired
	AreaDao areadao;

	@Autowired
	UserDao userDao;

	public long addProperty(Property property) {
		User ad = (User) session.getAttribute("user");
		property.setUserId(ad.getUserId());
		property.setIsActive(1);
		long p = propertyDao.addProperty(property);

		return p;
	}

	public int deleteProperty(long id) {
		Property property = propertyDao.getById(Property.class, id);
		if (property != null) {
			property.setIsDeleted(1);
			propertyDao.updateObject(property);
		}
		return 0;
	}

	public long updateProperty(Property property) {
		Property oldad = propertyDao.getById(Property.class, property.getPropertyId());
		User ad = (User) session.getAttribute("user");
		Property p1 = propertyDao.updateObject(property);

		return p1.getPropertyId();
	}

	public List<Property> getAll() {

		List<Property> propertyList = propertyDao.getActive();
		return propertyList;

	}

	public Property getById(long id) {
		Property property = propertyDao.getById(Property.class, id);
		return property;
	}

	public List<Property> getAllPropertiesByUserId() {
		User ad = (User) session.getAttribute("user");
		return propertyDao.getPropertiesByUserId(ad.getUserId());
	}

	public Property getAllDetails(long id) {
		Property p = propertyDao.getById(Property.class, id);

		User u = userDao.getById(User.class, p.getUserId());
		p.setLname(u.getFname() + " " + u.getLname());
		p.setLemail(u.getEmail());
		p.setMno(u.getMobileNo());
		Area a = areadao.getAllDetails(p.getAreaId());
		p.setStateId(a.getStateId());
		p.setSname(a.getSname());
		p.setCity_id(a.getCity_id());
		p.setCname(a.getCname());
		p.setAname(a.getName());
		return p;
	}

	public List<Property> getAllRooms() {
		List<Property> propertyList = propertyDao.getRooms();
		return propertyList;

	}

	public List<Property> getAllBeds() {
		List<Property> propertyList = propertyDao.getBeds();
		return propertyList;

	}

	public List<Property> getAllApartments() {
		List<Property> propertyList = propertyDao.getApartments();
		return propertyList;

	}

	public List<Property> getAllPropertiesByArea() {
		List<Property> propertyList = propertyDao.getAllPropertiesByArea();
		return propertyList;
	}

	public List<Property> getrecent() {
		List<Property> propertyList = propertyDao.getrecent();
		return propertyList;
	}

}
