package me.web.controller;

import com.alibaba.fastjson.JSONObject;
import me.domain.Message;
import me.service.CheckEmailService;
import me.service.Impl.CheckEmailServiceImpl;
import me.service.SendEmailService;
import me.service.Impl.SendEmailServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: wt
 * @Date: 2019/2/18 16:16
 */
@WebServlet(value = "/FindPasswordServlet")
public class FindPasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String email = request.getParameter("email");
        Message message = new Message();
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
        CheckEmailService checkEmailService = new CheckEmailServiceImpl();
        //验证
        if(checkEmailService.check(account, email)) {
            SendEmailService sendEmailService = new SendEmailServiceImpl();
            sendEmailService.send(account,email);
            message.setCode(0);
            message.setDetail("邮件发送成功，请及时查收！");
        } else {
            message.setDetail("信息输入有误，请核实后重新输入！");
        }
        response.getWriter().println(JSONObject.toJSONString(message));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
