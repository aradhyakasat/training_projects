package com.visa.prj.dao;

import com.visa.prj.entity.Mobile;
public interface MobileDao {
	int MAX=100; //constant=> public static final int MAX=100  ...final keyword for a constant
	void addMobile(Mobile mobile);   //abstract and public by default

}
