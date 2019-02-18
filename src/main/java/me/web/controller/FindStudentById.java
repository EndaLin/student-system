package me.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.domain.ErrorMess;
import me.domain.Student;
import me.service.Impl.FindStudentByIdServiceImpl;

/**
 * Servlet implementation class FindStudentByIdTest
 */
@WebServlet("/FindStudentById")
public class FindStudentById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindStudentById() {
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
		HttpSession session = request.getSession();
		Student stu = null;
		try {
			stu = FindStudentByIdServiceImpl.find(id);  //调用查找学生信息的方法
		} catch (ErrorMess errorMess) {
			errorMess.printStackTrace();
		}
		if(stu != null) {
			session.setAttribute("stu", stu);
		} else {
			session.setAttribute("message", "没有找到该生信息!");
		}
		request.getRequestDispatcher("/showStuById.jsp").forward(request, response);
	}

}
