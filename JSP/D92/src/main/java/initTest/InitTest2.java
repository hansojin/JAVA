package initTest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = {"/InitTest2"},
		initParams = {
				@WebInitParam(name="startNum", value="1"),
				@WebInitParam(name = "endNum", value="100")
		})
public class InitTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InitTest2() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		방법 3
		ServletConfig config = this.getServletConfig();
		String startNumStr = config.getInitParameter("startNum");
		String endNumStr = this.getInitParameter("endNum");
		
		int startNum = Integer.parseInt(startNumStr);
		int endNum = Integer.parseInt(endNumStr);
		
		int sum=0;
		for (int i=startNum;i<=endNum;i++) {
			sum+=i;
		}
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		out.println("SUM : " + sum);		
		out.println("</body>");
		out.println("</html>");
	}

}
