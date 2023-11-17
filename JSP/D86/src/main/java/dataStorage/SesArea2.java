package dataStorage;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SesArea2")
public class SesArea2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SesArea2() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String one = (String)request.getAttribute("one");
		HttpSession session = request.getSession();
		String two = (String)session.getAttribute("two");
		Calendar three = (Calendar)session.getAttribute("three");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = format.format(three.getTime());
		
		response.setContentType("text/html;charset=utf-8");	
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><body>");
		out.println("data1 = " + one + "<br/>");
		out.println("data2 = " + two + "<br/>");
		out.println("data3 = " + date + "<br/><br/>");
		
		out.println("<a href='SesArea3'>다음페이지로</a>");
		// 다음 페이지로 이동하여 request scope의 데이터는 더 이상 존재하지 않음을 확인
		// session scope의 데이터는 웹 페이지가 사라질 때 까지 존재
		out.println("</body></html>");
	}

}
