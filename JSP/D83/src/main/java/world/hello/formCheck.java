package world.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/formCheck")
public class formCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public formCheck() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<title>FORM CHECK</title>");
		out.print("</head>");
		out.print("<body>");

		request.setCharacterEncoding("UTF-8");
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			String[] values = request.getParameterValues(name);

			out.write(name + " : ");
			for (int i = 0; i < values.length; i++)
				out.write(values[i] + " ");
			out.write("<br>");
		}

		out.print("</body>");
		out.print("</html>");
	}
}
