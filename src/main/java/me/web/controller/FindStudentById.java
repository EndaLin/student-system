package me.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import me.domain.ErrorMess;
import me.domain.Message;
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
		// TODO Auto-generated method stub
		int id = Integer.valueOf(request.getParameter("id"));
		//HttpSession session = request.getSession();
		Student stu = null;
		Message message = new Message();
		try {
			//调用查找学生信息的方法
			stu = FindStudentByIdServiceImpl.find(id);
			if(stu != null) {
				//session.setAttribute("stu", stu);
				message.setCode(0);
				message.setDetail("查询成功");
				Map<String, Object> map = new HashMap<>();
				map.put("student", stu);
				message.setMessage(map);
			} else {
				//session.setAttribute("message", "没有找到该生信息!");
				message.setDetail("没有找到该生信息!");
			}
		} catch (ErrorMess errorMess) {
			errorMess.printStackTrace();
			message.setDetail(errorMess.getMessage());
		}
		//request.getRequestDispatcher("/showStuById.jsp").forward(request, response);
		response.getWriter().println(JSONObject.toJSONString(message));
	}

}
