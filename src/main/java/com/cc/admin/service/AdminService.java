package com.cc.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.admin.dao.AdminMapper;
import com.cc.admin.dto.Admin;

@Service
public class AdminService {
	
	@Autowired
	private AdminMapper adminMapper;
	
	public List<Admin> query(){
		return this.adminMapper.query("");
	}
	
	public Admin getById(Long id){
		return this.adminMapper.getById(id);
	}
	
	public void add(Admin admin){
		this.adminMapper.add(admin);
	}
	
	public void edit(Admin admin){
		this.adminMapper.edit(admin);
	}
	
	public void delete(Long id){
		this.adminMapper.delete(id);
	}
}
