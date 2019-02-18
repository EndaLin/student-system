package me.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.domain.User;
import me.service.Impl.LoginServiceImpl;
import me.web.UI.LoginUIServlet;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String account = request.getParameter("form-username");
		String password = request.getParameter("form-password");
		User user = new User(account, password, 0);  //封装表单传入的账号信息
		LoginServiceImpl.check(user);   //调用函数，判断账号的可用性
		if (user.getAccount() == null) {
			(new LoginUIServlet()).doGet(request, response);
			request.getSession().setAttribute("mess", "账号不存在,请核实后重新登陆!");
		} else if (user.getPassword() == null) {
			(new LoginUIServlet()).doGet(request, response);
			request.getSession().setAttribute("mess", "密码错误,请核实后重新登陆!");
		} else if (user.getType() == -1) {
			(new LoginUIServlet()).doGet(request, response);
			request.getSession().setAttribute("mess", "账号正在审核中!");
		} else {
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
