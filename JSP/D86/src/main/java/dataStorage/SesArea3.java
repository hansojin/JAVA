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

@WebServlet("/SesArea3")
public class SesArea3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SesArea3() {
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
		out.println("data1 = " + one + "<br/>");	// null 출력 
		out.println("data2 = " + two + "<br/>");
		out.println("data3 = " + date + "<br/><br/>");
		out.println("</body></html>");
	}

	

}
