package com.visa.prj.client;

import com.visa.dao.DaoException;
import com.visa.dao.EmployeeDao;
import com.visa.dao.EmployeeDaoJpaImpl;
import com.visa.prj.entity.Employee;

public class EmployeeClient {

	public static void main(String[] args) {
		int choice,id;
		EmployeeDao dao=new EmployeeDaoJpaImpl();
		String name;
		KeyboardUtil k=new KeyboardUtil();
		System.out.println("Select \n 1 to add employee \n 2 to raise issue \n 3 to list open issues \n4 to resolve issue ");
		//EmployeeDao dao=new EmployeeDaoJpaImpl();
		//Employee e=new Employee()
		choice=k.getInt("Enter choice:");
		//System.out.println(choice);
		if(choice==1) {
			id=k.getInt("Enter Employee id");
			name=k.getString("Enter Employee name");
			Employee e=new Employee(id,name);
			try {
				dao.addEmployee(e);
			}catch (DaoException f) {
				f.printStackTrace();
			}
			
		}
		
	}

}
