package com.easypg.service;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.easypg.model.Property;

public interface PropertyService {
	
	  public int deleteProperty(long id);
	  public List<Property> getAll(); 
	  public Property getById(long l);
	  public List<Property> getPropertiesByUserId(long userId);
	 

}


