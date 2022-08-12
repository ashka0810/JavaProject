package com.easypguser.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easypguser.dao.CityDao;
import com.easypguser.model.City;
import com.easypguser.service.CityService;

@Service("cityservice")
@Transactional

public class CityServiceImpl implements CityService {

	@Autowired
	CityDao citydao;

//	public long addCity(City city) {
//		return citydao.addCity(city);
//	}
//
//	public City editCity(long id) {
//		return citydao.editCity(id);
//	}
//
//	public boolean deleteCity(long id) {
//		return citydao.deleteCity(id);
//	}

	public List<City> getAll() {
		return citydao.getAll();
	}

	public City getById(long id) {
		return citydao.getById(id);
	}

	public List<City> getAllCitiesByStateId(long stateId) {
		return citydao.getAllCitiesByStateId(stateId);
	}

}
