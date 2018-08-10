package com.visa.dao;

import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Issue;

public interface EmployeeDao {
	void addEmployee(Employee e) throws DaoException;
	//void raiseIssue(Employee e) throws DaoException;
	//Issue getOpenIssues() throws DaoException;
	//void updateIssue(int id) throws DaoException;
	
	

}
