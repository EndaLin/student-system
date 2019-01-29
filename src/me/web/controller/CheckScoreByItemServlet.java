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

/**
 * Servlet implementation class CheckScoreByItemsServlet
 */
@WebServlet("/CheckScoreByItemServlet")
public class CheckScoreByItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckScoreByItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute("user");
	 	int sid = Integer.parseInt(user.getAccount()); //获取学号
		int item = Integer.parseInt(request.getParameter("item"));
		HttpSession session = request.getSession();
		try {
			ArrayList<Score> list = FindScoreByItemServiceImpl.find(sid, item);
			session.setAttribute("ScoreMess", list);
		} catch (ErrorMess e) {
			session.setAttribute("message1", e.getMessage());
		} finally {
			request.getRequestDispatcher("/checkScore.jsp").forward(request, response);
		}
	}

}
