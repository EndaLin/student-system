package me.web.controller;

import com.alibaba.fastjson.JSONObject;
import me.domain.Message;
import me.domain.User;
import me.service.Impl.FindAllAccountsWithoutCheckServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wt
 * @Date: 2019/2/20 16:34
 */
@WebServlet("/FindAllAccountsWithoutCheckServlet")
public class FindAllAccountsWithoutCheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<User> list = FindAllAccountsWithoutCheckServiceImpl.find();
        Message message = new Message();
        message.setCode(0);
        message.setDetail("查询成功");
        Map<String, Object> map = new HashMap<>();
        map.put("users", list);
        message.setMessage(map);
        response.getWriter().println(JSONObject.toJSONString(message));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
