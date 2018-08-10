package com.visa.prj.dao;

import com.visa.prj.entity.Customer;

public interface CustomerDao {
	Customer customerCheck(String email)throws DaoException;

}
