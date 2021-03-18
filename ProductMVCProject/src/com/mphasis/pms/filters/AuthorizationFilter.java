package com.mphasis.pms.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthorizationFilter
 */
@WebFilter("/*")
public class AuthorizationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthorizationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	response.setContentType("text/html");
		System.out.println("Filter called");
	HttpServletRequest req=(HttpServletRequest) request;
	HttpServletResponse res=(HttpServletResponse) response;
	PrintWriter out=res.getWriter();
	String url=req.getRequestURI();
	HttpSession session=req.getSession();
	String name=(String) session.getAttribute("sname");
	System.out.println(url);
	if(name == null && !(url.endsWith("index.html") 
					|| url.endsWith("login.html") ||
					url.endsWith("signup.html") ||
					url.endsWith("login")
				)) {
		out.print("UnAuthorized");
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
		rd.include(req, res);
	}else {
		chain.doFilter(req, res);
	}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
