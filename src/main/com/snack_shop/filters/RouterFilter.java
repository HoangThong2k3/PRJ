//package com.snack_shop.filters;
//
//import java.io.IOException;
//import javax.servlet.DispatcherType;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
//	, urlPatterns = { "/user/*" })
//public class RouterFilter extends HttpFilter implements Filter {
//
//	private static final long serialVersionUID = 1L;
//
//	public RouterFilter() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public void init(FilterConfig fConfig) throws ServletException {
//		// TODO Auto-generated method stub
//	}
//	public void destroy() {
//		// TODO Auto-generated method stub
//	}
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		HttpServletRequest req = (HttpServletRequest) request;
//		HttpServletResponse res = (HttpServletResponse) response;
//		String uri = req.getRequestURI();
//		HttpSession session = req.getSession();
//		if((session==null || session.getAttribute("userInfo")==null) &&  !(uri.contains("login.jsp") || uri.contains("LoginServlet")))
//		{
//			res.sendRedirect("login.jsp");
//		}
//		// pass the request along the filter chain
//		chain.doFilter(request, response);
//	}
//
//
//
//}