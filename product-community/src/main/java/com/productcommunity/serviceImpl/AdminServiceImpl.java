package com.productcommunity.serviceImpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcommunity.model.Admin;
import com.productcommunity.repository.AdminRepository;
import com.productcommunity.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepository adminRepo;

	@Override
	public List<Admin> getAllAdmin() {
		return adminRepo.findAll();
	}
	
	@Override
	public Admin adminLogin(int adminId, String password) {
		Admin admin = adminRepo.findByAdminId(adminId);
		if (Objects.isNull(admin)) {
			return null;
		}
		if (admin.getPassword().equals(password)) {
			return admin;

		} else {
			return null;
		}

	}
}