package com.visa.prj.dao;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Registration;

public interface RegistrationDao {
	void register(Registration reg);

}
