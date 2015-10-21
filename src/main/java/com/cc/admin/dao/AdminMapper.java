package com.cc.admin.dao;

import java.util.List;

import com.cc.admin.dto.Admin;

public interface AdminMapper {
	
	public Long add(Admin user);
	
	public void update(Admin user);
	
	public Admin getById(Long id);
	
	public Admin getByPhone(String cellPhone);
	
	public Admin getByName(String username);
	
	public List<Admin> query(String role);
}
