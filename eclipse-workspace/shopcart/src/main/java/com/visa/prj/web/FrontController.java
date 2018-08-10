package com.visa.prj.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.visa.prj.dao.CustomerDao;
import com.visa.prj.dao.CustomerDaoJpaImpl;
import com.visa.prj.dao.DaoException;
import com.visa.prj.dao.ProductDao;
import com.visa.prj.dao.ProductDaoJpaImpl;
import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Product;

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
			if (uri.endsWith("login.do")) {
				// use CustomerDao to check if user is a valid user
				CustomerDao customerDao=new CustomerDaoJpaImpl();
				Customer c=new Customer();
				String email=request.getParameter("email");
				// true creates a session of session doesn't exist else it fetches existing
				// session
				// false =>fetching existing session if it exists. Doesn't Create
				try {
					c=customerDao.customerCheck(email);
					
				} catch (DaoException e) {
					e.printStackTrace();
				}
				if(c!=null) {
				HttpSession ses = request.getSession(); // request.getSesssion(boolean); basically creating a session object
				ses.setAttribute("email", request.getParameter("email"));
				response.sendRedirect("index.jsp");
				}
				else {
					response.sendRedirect("login.jsp?msg=Enter correct email id");
				}

			} else if(uri.endsWith("logout.do")){
				HttpSession ses=request.getSession(false);
				if(ses!=null) {
					ses.invalidate();   //terminate the session
				}
			} else if(uri.endsWith("addProduct.do")) {
				ProductDao productDao=new ProductDaoJpaImpl();
				Product p=new Product();
				p.setName(request.getParameter("name"));
				p.setPrice(Double.parseDouble(request.getParameter("price")));
				p.setQuantity(Integer.parseInt(request.getParameter("qty")));
				try {
					productDao.addProduct(p);
				} catch (DaoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				response.sendRedirect("addProduct.jsp" + "?msg=Product added successfully!!!");
				
			} else if(uri.endsWith("listProduct.do")) {
				ProductDao productDao=new ProductDaoJpaImpl();
				List <Product> p=null;
				try {
					p=productDao.getProducts();
				} catch (DaoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("p",p );
				request.getRequestDispatcher("listProduct.jsp").forward(request, response);
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
