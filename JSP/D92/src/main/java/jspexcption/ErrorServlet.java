package jspexcption;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ErrorServlet")
public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ErrorServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sn=request.getParameter("n");
		String sm=request.getParameter("m");
		
		int n=0,m=0;
		try {
			n=Integer.parseInt(sn);
			m=Integer.parseInt(sm);
		}catch(NumberFormatException e) {
			response.sendError(510, "NaN ERROR");
			return;
		}
		
		int res=0;
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			res=n/m;
		}catch(ArithmeticException e) {
			response.sendError(511, "ArithmeticException");
			return;
		}
		
		out.println("<!doctype html>");
		out.println("<html><body>");
		out.println(n + " / " + m + " = " + res);
		out.println("</body></html>");
		out.close();
	}


}
