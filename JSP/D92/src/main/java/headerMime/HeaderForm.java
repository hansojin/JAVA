package headerMime;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HeaderForm")
public class HeaderForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HeaderForm() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String[] skills = request.getParameterValues("skill");
		
		// 헤더 정보의 이름-값들 획득
		Enumeration<String> enu = request.getHeaderNames();
		Vector<String> names = new Vector<>();
		Vector<String> values = new Vector<>();
		while(enu.hasMoreElements()) {
			String header_name = enu.nextElement();
			String header_value = request.getHeader(header_name);
			names.add(header_name);
			values.add(header_value);
		}
		
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("name : " + name + "<br/>");
		out.println("skil : ");
		for(int i = 0; i < skills.length; ++i) {
			out.println(skills[i] + "&nbsp;");
		}
		out.println("<br><hr><br>");
		for(int i=0;i<names.size();i++) {
			String header_name = names.elementAt(i);
			String header_value = values.elementAt(i);
			out.println(header_name + " : " + header_value + "<br/>");
		}
		out.println("</body></html>");
		out.close();
	}

}
