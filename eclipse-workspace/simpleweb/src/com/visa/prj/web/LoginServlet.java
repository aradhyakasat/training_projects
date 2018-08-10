package com.visa.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HashMap<String, String> users=new HashMap<>();
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		users.put("Gavin", "King123");
		users.put("Harry", "Secret123");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("user");
		String pwd=request.getParameter("pwd");
		if(users.containsKey(user)) {
			if(users.get(user).equals(pwd)) {
				Cookie c1=new Cookie("user",user);
				c1.setMaxAge(60*60*24);   //keep logged in for 1 day persistent cookie...default -1
				response.addCookie(c1);
				response.sendRedirect("index.html");
				return;
			}
		response.sendRedirect("login.html");	
			
		}
	}

}
