package com.visa.prj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.EmployeeDao;

@Service
public class EmployeeService {
	
	@Autowired
	@Qualifier("employeeDaoMemImpl")
	private EmployeeDao employeeDao; //ByteCode Instrumentation
	
	public void doTask() {
		employeeDao.addEmployee();
	}

}
