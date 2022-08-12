package com.easypg.serviceimpl;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.easypg.model.Admin;

import com.easypg.dao.AdminDao;
import com.easypg.service.AdminService;

@Service("adminservice")
@Transactional
@SessionAttributes("admin")
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;

	@Autowired
	HttpSession session;

	public long saveupdateAdmin(Admin admin) {
		admin.setIsActive(1);
		admin.setPassword("Root@123");
		Admin newAdmin = adminDao.saveupdateAdmin(admin);
		return 0;
	}

	public long addAdmin(Admin admin) {
		Admin ad = (Admin) session.getAttribute("admin");
		admin.setIsActive(1);
		admin.setPassword("Root@123");

		Admin a = adminDao.saveObject(admin);
		return 0;
	}

	public Admin editAdmin(int id) {

		return null;
	}

	public int deleteAdmin(int id) {
		Admin admin = adminDao.getById(Admin.class, id);
		if (admin != null) {
			admin.setIsDeleted(1);
			adminDao.updateObject(admin);
		}
		return 0;
	}

	public List<Admin> getAll() {
		List<Admin> adminList = adminDao.getActive();
		return adminList;
	}

	public int updateAdmin(Admin admin) {
		Admin oldad = adminDao.getById(Admin.class, admin.getAdminId());
		Admin ad = (Admin) session.getAttribute("admin");
		adminDao.updateObject(admin);
		return 0;
	}

	public Admin getById(long id) {
		Admin admin = adminDao.getById(Admin.class, id);
		return admin;
	}
}
