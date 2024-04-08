package com.hoangtuyen04work.controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hoangtuyen04work.model.User;

// , "/signup" không cần dùng đến

@WebServlet(urlPatterns = {"/home", "/login"})
public class HomeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4208211026893352889L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getParameter("action");
		if(action != null && action.equals("signup")){
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/signup.jsp");
			requestDispatcher.forward(req, resp);
		}
		else if(action == null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/login.jsp");
			requestDispatcher.forward(req, resp);
		}
		else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/signup.jsp");
			requestDispatcher.forward(req, resp);
		}

	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action != null && action.equals("signup")){
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/signup.jsp");
			requestDispatcher.forward(req, resp);
		}
		else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/web/profile.jsp");
			requestDispatcher.forward(req, resp);
		}
	}
}
