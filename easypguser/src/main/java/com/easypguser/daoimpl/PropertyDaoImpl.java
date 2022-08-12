package com.easypguser.daoimpl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.easypguser.dao.PropertyDao;

import com.easypguser.model.Property;
import com.easypguser.util.DbUtility;

@Repository("propertyDao")
@SessionAttributes("user")

public class PropertyDaoImpl extends GenericDaoImpl<Property> implements PropertyDao {

	@Autowired
	HttpSession session;

	public Property saveupdateProperty(Property property) {
		return super.saveUpdateObject(property);
	}

	public List<Property> getActive() {
		List<Property> list = DbUtility.getListData(
				"select p.propertyId as propertyId,p.title as title,p.status as status,p.address as address,p.rent as rent,p.userId as userId ,u.fname as fname,u.lname as lname FROM property p INNER JOIN user_master u ON p.userId=u.userId WHERE p.isDeleted=0 and u.isDeleted=0 and p.status='vacant'",
				Property.class);
		return list;
	}

	public List<Property> getPropertiesByUserId(long userId) {
		List<Property> list = DbUtility.getListData(
				"SELECT p.propertyId as propertyId,p.userId as userId ,p.title as title,p.type as type,p.rent as rent,p.status as status FROM property p WHERE p.isDeleted = 0 AND p.userId ="
						+ userId,
				Property.class);
		return list;
	}

	public long addProperty(Property property) {

		return super.saveObject(property).getPropertyId();
	}

	public List<Property> getRooms() {
		List<Property> list = DbUtility.getListData(
				"select p.propertyId as propertyId,p.title as title,p.status as pstatus,p.address as address,p.rent as rent,p.type as type,p.userId as userId ,u.fname as fname FROM property p INNER JOIN user_master u ON p.userId=u.userId WHERE p.isDeleted=0 and u.isDeleted=0 and p.type='room'",
				Property.class);
		return list;

	}

	public List<Property> getBeds() {
		List<Property> list = DbUtility.getListData(
				"select p.propertyId as propertyId,p.title as title,p.status as pstatus,p.address as address,p.rent as rent,p.type as type,p.userId as userId ,u.fname as fname FROM property p INNER JOIN user_master u ON p.userId=u.userId WHERE p.isDeleted=0 and u.isDeleted=0 and p.type='bed'",
				Property.class);
		return list;
	}

	public List<Property> getApartments() {
		List<Property> list = DbUtility.getListData(
				"select p.propertyId as propertyId,p.title as title,p.status as pstatus,p.address as address,p.rent as rent,p.type as type,p.userId as userId ,u.fname as fname FROM property p INNER JOIN user_master u ON p.userId=u.userId WHERE p.isDeleted=0 and u.isDeleted=0 and p.type='appartment'",
				Property.class);
		return list;
	}

	public List<Property> getAllPropertiesByArea() {
		List<Property> list = DbUtility.getListData("select p.propertyId as propertyId,p.title as title,\r\n"
				+ "				a.areaName as area,c.city_name as city		\r\n"
				+ "				 FROM property p \r\n"
				+ "				INNER JOIN area_info a ON a.areaId = p.areaId \r\n"
				+ "				INNER JOIN city_info c ON c.city_id=a.city_id where city_name='indore' and areaName='rh'\r\n"
				+ "", Property.class);
		return list;
	}

	public List<Property> getrecent() {
		List<Property> list = DbUtility.getListData(
				"select p.onlyfor as onlyFor,p.propertyId as propertyId,p.title as title,p.status as pstatus,\r\n"
						+ "p.address as address,\r\n"
						+ "p.rent as rent,p.type as type,p.userId as userId ,u.fname as fname ,u.lname as lname\r\n"
						+ "FROM property p INNER JOIN user_master u ON p.userId=u.userId\r\n"
						+ " WHERE p.isDeleted=0 and u.isDeleted=0 order by p.propertyId desc limit 3",
				Property.class);
		return list;
	}
}
