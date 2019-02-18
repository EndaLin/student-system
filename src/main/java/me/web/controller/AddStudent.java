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
import me.service.Impl.AddStudentServiceImpl;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
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
		String name = request.getParameter("name");
		String cid = request.getParameter("type");
		Student stu = new Student(0, name, Integer.valueOf(cid), null, 0);
		HttpSession session = request.getSession();
		try {
			AddStudentServiceImpl.add(stu);   //调用添加学生信息的方法
			session.setAttribute("message", "添加成功!");
		} catch (ErrorMess e) {
			session.setAttribute("message", e.getMessage());
		} finally {
			request.getRequestDispatcher("/AddStudent.jsp").forward(request, response);
		}
	}

}
