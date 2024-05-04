package com.hoangtuyen04work.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hoangtuyen04work.model.User;
import com.hoangtuyen04work.service.IUserService;
// , "/signup" không cần dùng đến
import com.hoangtuyen04work.service.impl.UserService;
import com.hoangtuyen04work.utils.FormUtil;
import com.hoangtuyen04work.utils.SessionUtil;

@WebServlet(urlPatterns = { "/profile" })
public class ProfileController extends HttpServlet {

	/**
	 * 
	 */

	@Inject
	User userInput;

	@Inject
	private User user;

	@Inject
	private IUserService userService;

	private static final long serialVersionUID = 4208211026893352889L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(SessionUtil.getInstance().getValue(req, "USER") == null) {
			resp.sendRedirect(req.getContextPath() + "/signin");
		}
		else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/web/profile.jsp");
			requestDispatcher.forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}