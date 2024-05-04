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
		System.out.println("6");
		String action = req.getParameter("action");
		System.out.println(action);
		if(action != null) {
			System.out.println("7");

			if(action.equals("signup")) {
				System.out.println("8");
	            resp.sendRedirect(req.getContextPath() + "/signup");
			}
		}
		else {
			System.out.println("9");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/signup.jsp");
			requestDispatcher.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		System.out.println("1");
		System.out.println(action);
		if(action != null)
		{
			System.out.println("1");

			if(action.equals("signup")) 
				
			{
				System.out.println("2");

				userInput = FormUtil.toModel(User.class, req);
				if(userService.checkUserExistence(userInput) == false)
				{
					System.out.println("3");

					userService.addUser(userInput);
					user = userService.findUserByUserId(userInput.getUserId(), userInput.getPassWord(), 1l);
					SessionUtil.getInstance().putValue(req, "USER", user);
					resp.sendRedirect(req.getContextPath() + "/profile");
				}
				else
				{
					System.out.println("4");

					resp.sendRedirect(req.getContextPath() + "/signup");
				}
				
			}
		}
		else 
		{	
			System.out.println("5");

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/signup.jsp");
			requestDispatcher.forward(req, resp);
		}
	}

}