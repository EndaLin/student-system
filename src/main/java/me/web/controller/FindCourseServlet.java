package me.web.controller;

import com.alibaba.fastjson.JSONObject;
import me.domain.Course;
import me.service.Impl.FindAllCourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: wt
 * @Date: 2019/2/19 15:28
 */
@WebServlet(value = "/FindCourseServlet")
public class FindCourseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String current = request.getParameter("current");
        FindAllCourseServiceImpl findAllCourseService = new FindAllCourseServiceImpl();
        List<Course> listCourse = findAllCourseService.findByCurrentPage(current);
        response.getWriter().println(JSONObject.toJSONString(listCourse));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
