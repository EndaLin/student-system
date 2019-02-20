package me.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import me.domain.Message;
import me.domain.Student;
import me.service.FindDatabaseCountService;
import me.service.Impl.FindDatabaseCountServiceImpl;
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
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		FindDatabaseCountService findDatabaseCountService = new FindDatabaseCountServiceImpl();
		Message message = findDatabaseCountService.checkForStudent(id);
		response.getWriter().println(JSONObject.toJSONString(message));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String current = request.getParameter("current");
		List<Student> list = null;
		Message message = new Message();
		FindDatabaseCountService findDatabaseCountService = new FindDatabaseCountServiceImpl();
		list = findDatabaseCountService.findByCurrentPages2(id, current);
		Map<String, Object> map = new HashMap<>();
		map.put("student", list);
		message.setCode(0);
		message.setDetail("查询成功");
		message.setMessage(map);
		//HttpSession session = request.getSession();
		//list = FindStudentByCidServiceImpl.find(id);
		if(list == null || list.isEmpty()) {
			//session.setAttribute("message", "没有找到相关学生的信息!");
			message.setDetail("没有找到相关学生的信息!");
		} else {
			//session.setAttribute("sublist", list);
		}
		//request.getRequestDispatcher("/showStuByClass.jsp").forward(request, response);
		response.getWriter().println(JSONObject.toJSONString(message));
	}

}
