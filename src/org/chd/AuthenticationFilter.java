package org.chd;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter {

	private FilterConfig filterConfig;
	private String onErrorUrl;
	public void destroy() {
		

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain next) throws IOException, ServletException {
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		HttpServletResponse httpResponse=(HttpServletResponse)response;
		HttpSession httpSession = httpRequest.getSession();
		if (httpSession.getAttribute(MisConstants.ISLOGINED_KEY) == null)
		{
			
			httpRequest.getRequestDispatcher(onErrorUrl).forward(httpRequest,httpResponse);
		}
		if (httpSession.getAttribute(MisConstants.ISLOGINED_KEY) != null)	
		{
			String path = httpRequest.getRequestURI().substring(1,4);
			String loginkey=(String)httpSession.getAttribute(MisConstants.ISLOGINED_KEY);
			if(!loginkey.equals(path))
					{
				  httpRequest.getRequestDispatcher(onErrorUrl).forward(httpRequest,httpResponse);
					}
		
		
			next.doFilter(httpRequest, httpResponse);
		}

	}

	public void init(FilterConfig config) throws ServletException {
		filterConfig = config;
		onErrorUrl=filterConfig.getInitParameter("onError");
		if (onErrorUrl==null || "".equals(onErrorUrl)){
			onErrorUrl="/error.jsp";
		}

	}

}
