package dataStorage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReqArea2")
public class ReqArea2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ReqArea2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data1 = (String)request.getAttribute("data1");
		Vector<String> data2 = (Vector<String>)request.getAttribute("data2");
		String data3 = request.getParameter("data3");
		String data4 = request.getParameter("data4");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		out.println("data1 = " + data1 + "<br>");
		out.println("data2 = ");
		for(int i=0;i<data2.size();i++)
			out.println(data2.get(i));
		out.println("<br/>");
		out.println("data3 = " + data3 + "<br/>");
		out.println("data4 = " + data4 + "<br/>");
		out.println("</body>");
		out.println("</html>");
	}

}
