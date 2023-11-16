package member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MemberRegisterOK")
public class MemberRegisterOK extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String mysqlUrl = "jdbc:mysql://localhost/hellojsp?serverTimezone=UTC";	
	private String mysqlUser = "root";
	private String mysqlPassword = "1234";
       
    public MemberRegisterOK() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int result = 0;
		String mobilePhone = null, hobby = "";
		String[] temp = null;
		String sql = "INSERT INTO MEMBER2 (NAME, ID, PASSWORD, SEX, EMAIL, MOBILEPHONE, HOBBY) VALUES(?, ?, ?, ?, ?, ?, ?)";
		try {
			Class.forName(driver);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		try(Connection conn = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPassword);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, request.getParameter("name"));
			pstmt.setString(2, request.getParameter("id"));
			pstmt.setString(3, request.getParameter("password"));
			pstmt.setString(4, request.getParameter("sex"));
			pstmt.setString(5, request.getParameter("email"));
			mobilePhone = request.getParameter("mobilePhone1") + request.getParameter("mobilePhone2");
			pstmt.setString(6, mobilePhone);
			temp = request.getParameterValues("hobby");
			for(int i=0;i<temp.length;i++)
				hobby += temp[i] + " ";
			pstmt.setString(7, hobby);
			result = pstmt.executeUpdate();
			if(result >= 1) 
				response.sendRedirect("main.jsp");
			else {
				request.setAttribute("errMSG", "데이터베이스 입력실패");
				request.setAttribute("url", "main.jsp");
				RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}