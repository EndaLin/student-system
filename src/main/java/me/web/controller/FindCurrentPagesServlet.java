package me.web.controller;

import com.alibaba.fastjson.JSONObject;
import me.domain.Classes;
import me.service.FindDatabaseCountService;
import me.service.Impl.FindDatabaseCountServiceImpl;
import oracle.jrockit.jfr.StringConstantPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: wt
 * @Date: 2019/2/19 11:11
 */
@WebServlet(value = "/FindCurrentPagesServlet")
public class FindCurrentPagesServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String current = request.getParameter("current");
        FindDatabaseCountService findDatabaseCountService = new FindDatabaseCountServiceImpl();
        List<Classes> list = findDatabaseCountService.findByCurrentPages(id, current);
        response.getWriter().println(JSONObject.toJSONString(list));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
