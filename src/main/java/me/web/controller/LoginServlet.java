package me.web.controller;

import com.alibaba.fastjson.JSONObject;
import me.domain.Message;
import me.domain.User;
import me.service.IBase64Service;
import me.service.Impl.LoginServiceImpl;
import me.service.MD5Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        Message message = new Message();
        String account = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("code");
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
        try {
            byte[] resultBytes;
            //加密
            resultBytes = MD5Service.eccrypt(password);
            String msg = new String(resultBytes);
            //修改编码
            password = IBase64Service.getBase64(msg);

            message.setCode(1);
            //封装表单传入的账号信息
            User user = new User(account, password, 0);
            //调用函数，判断账号的可用性
            LoginServiceImpl.check(user);
            if (user.getAccount() == null) {
                //(new LoginUIServlet()).doGet(request, response);
                //request.getSession().setAttribute("mess", "账号不存在,请核实后重新登陆!");
                message.setDetail("账号不存在,请核实后重新登陆!");
            } else if (user.getPassword() == null) {
                //(new LoginUIServlet()).doGet(request, response);
                //request.getSession().setAttribute("mess", "密码错误,请核实后重新登陆!");
                message.setDetail("密码错误,请核实后重新登陆!");
            } else if (user.getType() == -1) {
                //(new LoginUIServlet()).doGet(request, response);
                //request.getSession().setAttribute("mess", "账号正在审核中!");
                message.setDetail("账号正在审核中!");
            } else {
                //request.getSession().setAttribute("user", user);
                //request.getRequestDispatcher("/index.jsp").forward(request, response);
                message.setCode(0);
                message.setDetail(JSONObject.toJSONString(user));
            }
            //System.out.println(JSONObject.toJSONString(message));
            response.getWriter().println(JSONObject.toJSONString(message));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
