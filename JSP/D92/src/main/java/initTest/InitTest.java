package initTest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/InitTest")
public class InitTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InitTest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		web.xml <servlet> InitTest tag 확인
		
//		방법 1	
//		String startNumStr = getInitParameter("startNum");
//		String endNumStr = getInitParameter("endNum");

//		방법 2	
		ServletConfig config = this.getServletConfig();
		// HttpServlet이 ServletConfig를 구현했기 때문에, 객체를 획득할 필요 없이 this를 사용해도 무방
		String startNumStr = config.getInitParameter("startNum");
		String endNumStr = this.getInitParameter("endNum");
		// config 객체 혹은 this를 통해서 초기화 매개변수 획득 가능
		
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
