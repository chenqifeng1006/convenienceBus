package com.cc.driver.dao;

import java.util.List;

import com.cc.driver.dto.Driver;

public interface DriverMapper {
	
	public Long add(Driver driver);
	
	public void edit(Driver driver);
	
	public void delete(Long id);
	
	public Driver getById(Long id);
	
	public List<Driver> query();
}
