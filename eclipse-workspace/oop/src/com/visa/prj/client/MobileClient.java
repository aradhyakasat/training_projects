package com.visa.prj.client;

import com.visa.prj.dao.MobileDao;
import com.visa.prj.dao.MobileDaoFileImpl;
import com.visa.prj.entity.Mobile; //ctrl shift o organises imports ctrl shif f formats code

public class MobileClient {

	public static void main(String[] args) {
		Mobile mobile = new Mobile(2, "OnePlus6T", 70000.00, "4G");
		MobileDao mobileDao = new MobileDaoFileImpl();
		mobileDao.addMobile(mobile);

	}

}
