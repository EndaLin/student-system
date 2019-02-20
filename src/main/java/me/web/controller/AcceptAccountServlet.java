package me.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import me.domain.Message;
import me.service.Impl.AcceptAccountServiceImpl;

/**
 * Servlet implementation class AcceptAccountServlet
 */
@WebServlet("/AcceptAccountServlet")
public class AcceptAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcceptAccountServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String account = request.getParameter("id");
		AcceptAccountServiceImpl.accept(account);
		//request.getRequestDispatcher("checkAccount.jsp").forward(request, response);
		Message message = new Message();
		message.setCode(0);
		message.setDetail("审核通过");
		response.getWriter().println(JSONObject.toJSONString(message));
	}

}
