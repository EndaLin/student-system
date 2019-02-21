package me.web.controller;

import com.alibaba.fastjson.JSONObject;
import me.domain.Classes;
import me.domain.Message;
import me.service.FindClassSizeService;
import me.service.Impl.FindClassSizeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wt
 * @Date: 2019/2/21 14:47
 */
@WebServlet(value = "/FindClassSizeServlet")
public class FindClassSizeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Message message = new Message();
        message.setCode(0);
        Map<String, Object> map = new HashMap<>();
        FindClassSizeService findClassSizeService = new FindClassSizeServiceImpl();
        List<Classes> listClasses = findClassSizeService.check();
        map.put("numbers", listClasses);
        message.setMessage(map);
        response.getWriter().println(JSONObject.toJSONString(message));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
