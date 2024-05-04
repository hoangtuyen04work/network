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

@WebServlet(urlPatterns = { "/signin" })
public class SigninController extends HttpServlet {

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
	    User usertmp = (User) SessionUtil.getInstance().getValue(req, "USER");	    
	    if (action != null) {
	        if (action.equals("signin") && usertmp != null) {
	            resp.sendRedirect(req.getContextPath() + "/profile");
	        } 
	        else if (action.equals("signout") && usertmp != null) 
	        {
	            SessionUtil.getInstance().removeValue(req, "USER");
	            resp.sendRedirect(req.getContextPath() + "/signin");
//	            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/signin.jsp");
//	            requestDispatcher.forward(req, resp);
	        } 
	        else if (action.equals("signin") && usertmp == null) 
	        {
	            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/signin.jsp");
	            requestDispatcher.forward(req, resp);
	        }
	        else if(action.equals("error")) 
	        {
                resp.sendRedirect(req.getContextPath() + "/signin");
	        }
	    } 
	    else 
	    {
	    	RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/signin.jsp");
            requestDispatcher.forward(req, resp);
	    }
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String action = req.getParameter("action");
	    if (action != null && action.equals("signin")) {
	        userInput = FormUtil.toModel(User.class, req);
	        if (isNotBlank(userInput.getUserId()) && isNotBlank(userInput.getPassWord())) {
	            Long state = 1L;
	            user = userService.findUserByUserId(userInput.getUserId(), userInput.getPassWord(), state);
	            if (user != null) {
	            	SessionUtil.getInstance().removeValue(req, "USER");
	                SessionUtil.getInstance().putValue(req, "USER", user);
	                if (user.getType().equals("ADMIN")) {
	                    resp.sendRedirect(req.getContextPath() + "/admin-home");
	                } 
	                else {
	                    resp.sendRedirect(req.getContextPath() + "/profile");
	                }
	            }
	            else {
	            	resp.sendRedirect(req.getContextPath() + "/signin");
	            }
	        }
	        else{
				resp.sendRedirect(req.getContextPath()+"/signin?action=error");
	        }
	    } else if (action == null) {
	        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/signin.jsp");
	        requestDispatcher.forward(req, resp);
	    }
	}
	public static boolean isNotBlank(String str) {
	    return str != null && !str.trim().isEmpty();
	}
}