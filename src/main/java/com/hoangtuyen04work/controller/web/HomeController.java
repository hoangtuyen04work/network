package com.hoangtuyen04work.controller.web;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hoangtuyen04work.model.Post;
import com.hoangtuyen04work.model.User;
import com.hoangtuyen04work.service.IPostService;
import com.hoangtuyen04work.service.IUserService;
import com.hoangtuyen04work.utils.FormUtil;
import com.hoangtuyen04work.utils.SessionUtil;

@WebServlet(urlPatterns = { "/home" })
public class HomeController extends HttpServlet {

	/**
	 * 
	 */
	@Inject
	private IPostService postService;
	@Inject
	private User userTmp;

	@Inject
	private User user;

	@Inject
	private IUserService userService;


	private static final long serialVersionUID = 4208211026893352889L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getParameter("action");
		//check alive user or not
		userTmp = (User) SessionUtil.getInstance().getValue(req, "USER");
		if(userTmp.getUserId() == null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/signin.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			List<Post> posts = postService.getPosts(userTmp);
			req.setAttribute("POSTS", posts);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/web/home.jsp");
			requestDispatcher.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getParameter("action");
		userTmp = (User) SessionUtil.getInstance().getValue(req, "USER");

		if ("addpost".equals(action)) 
		{
			Post post = (Post)FormUtil.toModel(Post.class, req);
			java.util.Date date = new java.util.Date();
			post.setCreatedDate(new Timestamp(date.getTime()));
			post.setIdUser(((User)SessionUtil.getInstance().getValue(req, "USER")).getUserId());
			postService.addPost(post);
			resp.sendRedirect(req.getContextPath() + "/home");
		} 
		else 
		{
			userTmp = (User) SessionUtil.getInstance().getValue(req, "USER");
			List<Post> posts = postService.getPosts(userTmp);
			req.setAttribute("POSTS", posts);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/web/home.jsp");
			requestDispatcher.forward(req, resp);
		}
	}
}