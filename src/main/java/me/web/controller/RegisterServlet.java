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
import me.domain.User;
import me.service.Impl.IBase64Service;
import me.service.Impl.RegisterServiceImpl;
import me.service.MD5Service;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String account = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String code = request.getParameter("code");
		Message message = new Message();
		String realCode = (String) request.getSession().getAttribute("validateCode");
		if (realCode == null) {
			message.setDetail("验证码已过期！");
			response.getWriter().println(JSONObject.toJSONString(message));
			return;
		} else if (!code.equals(realCode)) {
			message.setDetail("验证码错误！");
			response.getWriter().println(JSONObject.toJSONString(message));
			return;
		}
		//HttpSession session = request.getSession();
		try {
			byte[] resultBytes;
			//加密
			resultBytes = MD5Service.eccrypt(password);
			String msg = new String(resultBytes);
			//修改编码
			password = IBase64Service.getBase64(msg);
			User user = new User(account, password, 0, email);
			RegisterServiceImpl.add(user);
			message.setCode(0);
			message.setDetail("提交成功,审核通过后便能登陆!");
			//session.setAttribute("message", "提交成功,审核通过后便能登陆!");
		} catch (ErrorMess e) {
			message.setDetail(e.getMessage());
			//session.setAttribute("message", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			response.getWriter().println(JSONObject.toJSONString(message));
			//request.getRequestDispatcher("/WEB-INF/pages/Register.jsp").forward(request, response);
		}
	}

}
