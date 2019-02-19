package me.web.controller;

import com.alibaba.fastjson.JSONObject;
import me.domain.Classes;
import me.service.Impl.FindAllClassServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wt
 * @Date: 2019/2/19 14:40
 */
@WebServlet(value = "/GetAllClassesServlet")
public class GetAllClassesServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Classes> list = FindAllClassServiceImpl.find();
        response.getWriter().println(JSONObject.toJSONString(list));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
