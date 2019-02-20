package me.web.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import me.domain.Score;
import me.domain.User;
import me.service.Impl.FindScoreByCourseServiceImpl;

/**
 * Servlet implementation class CheckScoreByCourseServlet
 */
@WebServlet("/CheckScoreByCourseServlet")
public class CheckScoreByCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckScoreByCourseServlet() {
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
	 	int sid = Integer.parseInt(request.getParameter("id"));
		int courseid = Integer.parseInt(request.getParameter("courseid"));
		//HttpSession session = request.getSession();
		Message message = new Message();
		try {
			ArrayList<Score> list = FindScoreByCourseServiceImpl.find(sid, courseid);
			message.setCode(0);
			message.setDetail("查询成功");
			Map<String, Object> map = new HashMap<>();
			map.put("scores", list);
			message.setMessage(map);
			//session.setAttribute("ScoreMess", list);
		} catch (ErrorMess e) {
			message.setDetail(e.getMessage());
			//session.setAttribute("message1", e.getMessage());
		} finally {
			//request.getRequestDispatcher("/checkScore.jsp").forward(request, response);
			response.getWriter().println(JSONObject.toJSONString(message));
		}
	}

}
