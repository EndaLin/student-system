package me.web.controller;

import com.alibaba.fastjson.JSONObject;
import me.domain.Message;
import me.service.ChangePasswordService;
import me.service.Impl.ChangePasswordServiceImpl;
import me.service.IBase64Service;
import me.service.MD5Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: wt
 * @Date: 2019/2/18 17:07
 */
@WebServlet(value = "/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        try {
            byte[] resultBytes;
            //加密
            resultBytes = MD5Service.eccrypt(password);
            String msg = new String(resultBytes);
            //修改编码
            password = IBase64Service.getBase64(msg);
            Message message = new Message();
            ChangePasswordService changePasswordService = new ChangePasswordServiceImpl();
            changePasswordService.change(account, password);
            message.setCode(0);
            message.setDetail("修改成功!");
            response.getWriter().println(JSONObject.toJSONString(message));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
