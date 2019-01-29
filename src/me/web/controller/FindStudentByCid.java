package me.web.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.domain.Student;
import me.service.Impl.FindStudentByCidServiceImpl;

/**
 * Servlet implementation class FindStudentByCid
 */
@WebServlet("/FindStudentByCid")
public class FindStudentByCid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindStudentByCid() {
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
		int id = Integer.valueOf(request.getParameter("id"));
		ArrayList<Student> list = null;
		HttpSession session = request.getSession();
		list = FindStudentByCidServiceImpl.find(id);
		if(list == null) {
			session.setAttribute("message", "没有找到相关学生的信息!");
		} else {
			session.setAttribute("sublist", list);
		}
		request.getRequestDispatcher("/showStuByClass.jsp").forward(request, response);
	}

}
