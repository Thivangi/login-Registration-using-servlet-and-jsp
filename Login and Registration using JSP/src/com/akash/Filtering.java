package com.akash;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Filtering implements Filter {

	private ServletContext context;
	String email;
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.context=fConfig.getServletContext();
		
		
	}

	
    public Filtering() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		String url=req.getRequestURI();
		System.out.println("check"+url);
		
		HttpSession session=req.getSession();
		if(session.getAttribute("email")==null)
		{
			//res.sendRedirect("login.jsp");	
			//email=(String)session.getAttribute("email");
			//System.out.println(email);
			//session.removeAttribute("email");
			//session.invalidate();
				//System.out.println("check");
			res.sendRedirect("login.jsp");
				
		}
		else {
			chain.doFilter(request, response);
			
	
		}
			}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	
}
