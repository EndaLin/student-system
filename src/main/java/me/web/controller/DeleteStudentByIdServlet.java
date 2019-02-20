package me.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import me.domain.ErrorMess;
import me.domain.Message;
import me.domain.Student;
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
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(request.getParameter("id"));
		Message message = new Message();
		try {
			DeleteStudentByIdServiceImpl.delete(id);
			message.setCode(0);
			message.setDetail("删除成功！");
			Map<String, Object> map = new HashMap<>();
			map.put("student", (new Student()));
			message.setMessage(map);
		} catch(ErrorMess e) {
			message.setDetail(e.getMessage());
			e.printStackTrace();
		} finally {
			response.getWriter().println(JSONObject.toJSONString(message));
//			if(request.getServletPath().contains("/showStuById.jsp")) {
//				request.getRequestDispatcher("/showStuById.jsp").forward(request, response);
//			} else {
//				request.getRequestDispatcher("/showStuByClass.jsp").forward(request, response);
//			}
		}
	}

}
