package filter.myfilter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/MySessionFilter")
public class MySessionFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	public MySessionFilter() {
        super();
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hRequest = (HttpServletRequest)request;
		HttpSession hSession = hRequest.getSession();
		String id = (String)hSession.getAttribute("id");
		
		if(id == null || id.trim().length() == 0) {			
			HttpServletResponse h_response = (HttpServletResponse)response;
			h_response.sendRedirect("../error.jsp");			
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
