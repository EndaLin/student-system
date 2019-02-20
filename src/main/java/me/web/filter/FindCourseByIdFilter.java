package me.web.filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import me.domain.Course;
import me.domain.ErrorMess;
import me.domain.User;
import me.service.Impl.FindCourseBySidServiceImpl;

/**
 * Servlet Filter implementation class FindCourseByIdFilter
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE,
		DispatcherType.ERROR }, urlPatterns = { "/checkScore.jsp" })
public class FindCourseByIdFilter implements Filter {

    /**
     * Default constructor. 
     */
    public FindCourseByIdFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest hsr = (HttpServletRequest) request;
		HttpSession session = hsr.getSession();
		User user = (User) session.getAttribute("user");
		// 获取学生学号
		int sid = Integer.parseInt(user.getAccount());
		try {
			ArrayList<Course> courses = FindCourseBySidServiceImpl.find(sid);
			session.setAttribute("courses", courses);
		} catch (ErrorMess e) {
			// TODO Auto-generated catch block
			session.setAttribute("message", e.getMessage());
		} finally {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
