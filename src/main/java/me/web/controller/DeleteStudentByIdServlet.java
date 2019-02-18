package me.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.domain.ErrorMess;
import me.service.Impl.DeleteStudentByIdServiceImpl;

/**
 * Servlet implementation class DeleteStudentByIdServlet
 */
@WebServlet("/DeleteStudentByIdServlet")
public class DeleteStudentByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudentByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(request.getParameter("id"));
		try {
			DeleteStudentByIdServiceImpl.delete(id);
		} catch(ErrorMess e) {
			e.printStackTrace();
		} finally {
			if(request.getServletPath().contains("/showStuById.jsp")) {
				request.getRequestDispatcher("/showStuById.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/showStuByClass.jsp").forward(request, response);
			}
		}
	}

}
