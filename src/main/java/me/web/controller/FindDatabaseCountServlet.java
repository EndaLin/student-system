package me.web.controller;

import com.alibaba.fastjson.JSONObject;
import me.domain.Message;
import me.service.FindDatabaseCountService;
import me.service.Impl.FindDatabaseCountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: wt
 * @Date: 2019/2/19 10:18
 */
@WebServlet(value = "/FindDatabaseCountServlet")
public class FindDatabaseCountServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        FindDatabaseCountService findDatabaseCountService = new FindDatabaseCountServiceImpl();
        Message message = findDatabaseCountService.check(id);
        response.getWriter().println(JSONObject.toJSONString(message));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
