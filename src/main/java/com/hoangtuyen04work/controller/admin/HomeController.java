package com.hoangtuyen04work.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hoangtuyen04work.model.User;
import com.hoangtuyen04work.utils.SessionUtil;

@WebServlet(urlPatterns = {"/admin-home"})
public class HomeController extends HttpServlet {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 4208211026893352889L;

	@Inject
	User user;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		user = (User)SessionUtil.getInstance().getValue(req, "USER");
		if(user != null && user.getType() == "ADMIN") {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/home.jsp");
			requestDispatcher.forward(req, resp);
		}
		else {
			resp.sendRedirect(req.getContextPath() + "/signin");
		}
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
