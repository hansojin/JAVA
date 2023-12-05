package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FilterTestServlet")
public class FilterTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FilterTestServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
		out.println("<style type='text/css'>");
		out.println(".n_border { border:none }");
		out.println("</style></head><body>");
		out.println("전송된 이름 = ");
		out.println("<input type='text' class='n_border' value='" + name + "'/><br/>");
		out.println("전송된 전번 = ");
		out.println("<input type='text' class='n_border' value='" + tel + "'/><br/>");
		out.println("전송된 주소 = ");
		out.println("<input type='text' class='n_border' value='" + addr + "'/><br/>");
		out.println("</body></html>");
	}

}
