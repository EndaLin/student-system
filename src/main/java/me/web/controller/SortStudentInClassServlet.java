package me.web.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.domain.ErrorMess;
import me.domain.Score;
import me.domain.User;
import me.service.Impl.FindScoreByItemServiceImpl;
import me.service.Impl.SortStudentInClassServiceImpl;

/**
 * Servlet implementation class SortStudentInClassServlet
 */
@WebServlet("/SortStudentInClassServlet")
public class SortStudentInClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SortStudentInClassServlet() {
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
		User user = (User) request.getSession().getAttribute("user");
	 	int sid = Integer.parseInt(user.getAccount()); //获取学号
		int item = Integer.parseInt(request.getParameter("item")); // 学期
		HttpSession session = request.getSession();
		try {
			ArrayList<Score> list = SortStudentInClassServiceImpl.sort(sid, item);
			session.setAttribute("ScoreMess1", list);
		} catch (ErrorMess e) {
			session.setAttribute("message", e.getMessage());
		} finally {
			request.getRequestDispatcher("/sortScore.jsp").forward(request, response);
		}
	}
}
