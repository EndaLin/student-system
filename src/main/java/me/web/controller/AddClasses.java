package me.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import me.domain.ErrorMess;
import me.domain.Message;
import me.service.Impl.AddClassServiceImpl;

/**
 * Servlet implementation class AddClasses
 */
@WebServlet("/AddClasses")
public class AddClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClasses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String grade = request.getParameter("grade");
		Message message = new Message();
		//HttpSession session = request.getSession();
		try {
			//调用添加班级信息的方法
			AddClassServiceImpl.add(name,Integer.valueOf(grade));
			message.setCode(0);
			message.setDetail("添加成功!");
			 //session.setAttribute("message", "添加成功!");
		} catch (ErrorMess e) {
			message.setDetail(e.getMessage());
			 //session.setAttribute("message", e.getMessage());
		} finally {
			 //request.getRequestDispatcher("/AddClasses.jsp").forward(request, response);
			response.getWriter().println(JSONObject.toJSONString(message));
		}
	}

}
