package com.easypg.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.easypg.model.Admin;

public interface AdminService {
	public long addAdmin(Admin admin);
	public Admin editAdmin(int id);
	public int deleteAdmin(int id);
	public List<Admin> getAll();
	public int updateAdmin(Admin admin);
	public long saveupdateAdmin(Admin admin);
	public Admin getById(long l);
	
}
