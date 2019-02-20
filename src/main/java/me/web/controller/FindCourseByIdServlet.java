package me.web.controller;

import com.alibaba.fastjson.JSONObject;
import me.domain.Course;
import me.domain.ErrorMess;
import me.domain.Message;
import me.domain.User;
import me.service.Impl.FindAllItemServiceImpl;
import me.service.Impl.FindCourseBySidServiceImpl;

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
 * @Date: 2019/2/20 17:01
 */
@WebServlet("/FindCourseByIdServlet")
public class FindCourseByIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String id = request.getParameter("id");
        Message message = new Message();
        try {
            ArrayList<Course> listCourses = FindCourseBySidServiceImpl.find(Integer.valueOf(id));
            ArrayList<Integer> listItems = FindAllItemServiceImpl.find(Integer.valueOf(id));
            message.setCode(0);
            message.setDetail("查询成功");
            Map<String, Object> map = new HashMap<>();
            map.put("courses", listCourses);
            map.put("items", listItems);
            message.setMessage(map);
        } catch (ErrorMess e) {
            // TODO Auto-generated catch block
            //session.setAttribute("message", e.getMessage());
            message.setDetail(e.getMessage());
        } finally {
           // chain.doFilter(request, response);
            response.getWriter().println(JSONObject.toJSONString(message));
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
