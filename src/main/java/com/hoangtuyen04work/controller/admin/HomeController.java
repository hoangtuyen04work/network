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
//ths is my home controlle of admin but i think i will not use it because i don't make any feature for admin
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
			// xử lý trực tiếp và trả về 1 trang view mới
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/home.jsp");
			requestDispatcher.forward(req, resp);
		}
		else {
			// don't handle directly but redirect to another controller to handle
			resp.sendRedirect(req.getContextPath() + "/signin");
		}
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
