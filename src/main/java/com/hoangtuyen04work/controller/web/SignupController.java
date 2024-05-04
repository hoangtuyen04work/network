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
import com.hoangtuyen04work.service.impl.UserService;
import com.hoangtuyen04work.utils.FormUtil;
import com.hoangtuyen04work.utils.SessionUtil;
import com.microsoft.sqlserver.jdbc.StringUtils;

@WebServlet(urlPatterns = { "/signup" })
public class SignupController extends HttpServlet {

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
		String action = req.getParameter("action");
		if(action != null) {
			if(action.equals("signup")) {
	            resp.sendRedirect(req.getContextPath() + "/signup");
			}
		}
		else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/signup.jsp");
			requestDispatcher.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action != null)
		{
			if(action.equals("signup")) 
				
			{
				userInput = FormUtil.toModel(User.class, req);
				if(userService.checkUserExistence(userInput) == false)
				{
					userService.addUser(userInput);
					user = userService.findUserByUserId(userInput.getUserId(), userInput.getPassWord(), 1l);
					SessionUtil.getInstance().putValue(req, "USER", user);
					resp.sendRedirect(req.getContextPath() + "/profile");
				}
				else
				{
					resp.sendRedirect(req.getContextPath() + "/signup");
				}
				
			}
		}
		else 
		{	
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/signup.jsp");
			requestDispatcher.forward(req, resp);
		}
	}

}