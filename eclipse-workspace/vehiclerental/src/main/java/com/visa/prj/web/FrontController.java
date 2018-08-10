package com.visa.prj.web;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.visa.prj.dao.RentalDao;
import com.visa.prj.dao.RentalDaoJpaImpl;
import com.visa.prj.dao.VehicleDao;
import com.visa.prj.dao.VehicleDaoJpaImpl;
import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Rental;
import com.visa.prj.entity.Vehicle;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = "index.jsp";
		String uri = request.getRequestURI();
		if (uri != null) {
			if (uri.endsWith("addVehicle.do")) {
				VehicleDao vehicleDao = new VehicleDaoJpaImpl();
				Vehicle v = new Vehicle();
				v.setRegistrationNumber(request.getParameter("regNo"));
				v.setFuelType(request.getParameter("fuelType"));
				v.setType(request.getParameter("vehicleType"));
				v.setCostPerkm(Double.parseDouble(request.getParameter("cost")));
				vehicleDao.addVehicle(v);
				response.sendRedirect(page + "?msg=Vehicle added successfully!!!"); // client side redirection

			} else if (uri.endsWith("rentalForm.do")) {
				VehicleDao vehicleDao = new VehicleDaoJpaImpl();
				List<String> regNos = vehicleDao.getRegNos();
				request.setAttribute("regNos", regNos);
				request.getRequestDispatcher("rentalForm2.jsp").forward(request, response); // server side redirection
			} else if (uri.endsWith("hireVehicle.do")) {
				String regNo = request.getParameter("vehicle");
				String customerId = request.getParameter("customerId");
				String rentalAmount = request.getParameter("rentalAmount");

				Vehicle vehicle = new Vehicle();
				vehicle.setRegistrationNumber(regNo);

				Customer customer = new Customer();
				customer.setCustomerId(Integer.parseInt(customerId));

				Rental rental = new Rental();
				rental.setCustomer(customer);
				rental.setVehicle(vehicle);
				rental.setRentalAmount(Double.parseDouble(rentalAmount));
				rental.setRentalDate(new Date());
				RentalDao rentalDao = new RentalDaoJpaImpl();
				rentalDao.addRental(rental);
				response.sendRedirect(page + "?msg=Rental details saved!!!");
			} else if (uri.endsWith("report.do")) {
				RentalDao rentalDao = new RentalDaoJpaImpl();
				request.setAttribute("reports", rentalDao.getReport());
				request.getRequestDispatcher("report.jsp").forward(request, response);
			} else if (uri.endsWith("login.do")) {
				// use CustomerDao to check if user is a valid user

				// true creates a session of session doesn't exist else it fetches existing
				// session
				// false =>fetching existing session if it exists. Doesn't Create
				HttpSession ses = request.getSession(); // request.getSesssion(boolean); basically creating a session object
				ses.setAttribute("user", request.getParameter("pwd"));
				response.sendRedirect("index.jsp");

			} else if(uri.endsWith("logout.do")){
				HttpSession ses=request.getSession(false);
				if(ses!=null) {
					ses.invalidate();   //terminate the session
				}
			}
		}
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
