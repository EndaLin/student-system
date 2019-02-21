package me.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import me.service.Impl.AddCourseByExcelServiceImpl;
import me.service.Impl.AddCourseToStudentServiceImpl;
import me.service.Impl.AddStudentsByExcelServiceImpl;
import me.service.Impl.ModifyScoresByExcelServiceImpl;
import me.service.Impl.ReadExcelServiceImpl;

/**
 * Servlet implementation class SaveExcelServlet
 */
@WebServlet("/SaveExcelServlet")
public class SaveExcelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveExcelServlet() {
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
        String detail = null;
        String fileSaveName = null;
        String type = null;
        Path savePath = null;
        // 检测是否为多媒体上传
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 如果不是则停止
            PrintWriter writer = response.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return;
        }

        // 获取路径来存储文件
        String path = request.getSession().getServletContext().getRealPath("");
        System.out.println(Paths.get(path, "Data"));
        // 根据路径名创建一个 File实例
        File file = new File((Paths.get(path, "Data")).toString());
        if (!file.exists()) {
            file.mkdir(); // 如果不存在则创建此路径的目录
        }

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 中文处理
        upload.setHeaderEncoding("utf-8");

        try {
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
            for (FileItem item : formItems) {
                if (item.isFormField()) {
                    // 获取请求来源
                    type = item.getString();
                }
                if (!item.isFormField()) {
                    System.out.println("文件上传！");
                    String fileName = item.getName();
                    if (fileName.isEmpty()) {
                        continue;
                    }
                    System.out.println("上传的文件名：" + fileName);

                    // 获取文件名后缀, 返回 "."在文件名最后出现的索引, 就是文件后缀名
                    String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
                    // 存储的文件名根据获取的id来唯一确定, 这里测试使用 "test"
                    // id可以绑定到session或request变量等等，自己根据需要来扩展
                    fileSaveName = "test" + "." + prefix; // id.后缀

                    if (!prefix.equals("xlsx") && !prefix.equals("xls")) {
                        request.getSession().setAttribute("mess", "错误：上传的文件格式错误！请上传Excel表格");
                        request.getRequestDispatcher(type).forward(request, response);
                        return;
                    }
                    savePath = Paths.get(path, "Data", fileSaveName); // 组合路径
                    System.out.println(savePath.toString());

                    // 获取文件输入流
                    InputStream inputStream = item.getInputStream();
                    // 创建文件输出流，用于向指定文件名的文件写入数据
                    FileOutputStream fileOutputStream = new FileOutputStream(savePath.toString());
                    int index = 0;

                    // 从输入流读取数据的下一个字节，到末尾时返回 -1
                    while ((index = inputStream.read()) != -1) {
                        fileOutputStream.write(index); // 将指定字节写入此文件输出流
                    }

                    // 关闭流
                    inputStream.close();
                    fileOutputStream.close();
                    item.delete();

                }
            }
            // 调用读取Excel的方法
            ReadExcelServiceImpl poi = new ReadExcelServiceImpl();

            List<List<String>> list = poi.read(savePath.toString());
            System.out.print(type);
            System.out.println();
            switch (type) {
                case "AddStudent.html":
                    AddStudentsByExcelServiceImpl.add(list);
                    break;
                case "showCourse.html":
                    AddCourseByExcelServiceImpl.add(list);
                    break;
                case "AddScoreMess.html":
                    ModifyScoresByExcelServiceImpl.modify(list);
                    break;
                case "assignmentCourse.html":
                    AddCourseToStudentServiceImpl.add(list);
                    break;
                default:
                    break;
            }
            //request.getSession().setAttribute("message", "上传成功！");
            detail = "上传成功！";
        } catch (Exception e) {
            detail = e.getMessage();
//            request.getSession().setAttribute("message", "error" + e.getMessage());
            e.printStackTrace();
        } finally {
            Cookie cookie = new Cookie("detail", detail);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);
            //request.getRequestDispatcher(type).forward(request, response);
            response.sendRedirect(type);
        }
    }

}
