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
import me.service.Impl.ModifyStudentServiceImpl;

/**
 * Servlet implementation class ModifyStudentServlet
 */
@WebServlet("/ModifyStudentServlet")
public class ModifyStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyStudentServlet() {
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
		int sid = Integer.valueOf(request.getParameter("id"));
		String name = request.getParameter("name");
		int cid = Integer.valueOf(request.getParameter("cid"));
		Message message = new Message();
		//HttpSession session = request.getSession();
		try {
			ModifyStudentServiceImpl.modify(sid, name, cid);
			message.setCode(0);
			message.setDetail("修改成功！");
		} catch(ErrorMess e) {
			message.setDetail(e.getMessage());
			//session.setAttribute("message", e.getMessage());
		} finally {
			//request.getRequestDispatcher("/ModifyStudent.jsp").forward(request, response);
			response.getWriter().println(JSONObject.toJSONString(message));
		}
	}

}
