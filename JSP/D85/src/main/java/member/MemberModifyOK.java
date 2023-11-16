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
import javax.servlet.http.HttpSession;

@WebServlet("/MemberModifyOK")
public class MemberModifyOK extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberModifyOK() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = null, password = null, sex = null, email = null, hobby = "", mobilePhone = null;
		String[] tmp = null;
		String driver = "com.mysql.cj.jdbc.Driver";
		String mysqlUrl = "jdbc:mysql://localhost:3306/hellojsp?serverTimezone=UTC";
		String mysqlUser = "root";
		String mysqlPassword = "1234";
		int result = 0;
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		
		id = (String)session.getAttribute("id");
		password = request.getParameter("password");
		sex = request.getParameter("sex");
		email = request.getParameter("email");
		tmp = request.getParameterValues("hobby");
		for(int i=0;i<tmp.length;i++)
			hobby += tmp[i]+" ";
		mobilePhone = request.getParameter("mobilePhone1") + request.getParameter("mobilePhone2");
		System.out.println(id + " " + password + " " + sex + " " + email + " " + mobilePhone);

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "UPDATE MEMBER2 SET PASSWORD=?, SEX=?, EMAIL=?, HOBBY=?, MOBILEPHONE=? WHERE id=?";
		try(Connection conn = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPassword);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, password);
			pstmt.setString(2, sex);
			pstmt.setString(3, email);
			pstmt.setString(4, hobby);
			pstmt.setString(5, mobilePhone);
			pstmt.setString(6, id);
			result = pstmt.executeUpdate();

			if(result > 0) 
				response.sendRedirect("main.jsp");
			else {
				request.setAttribute("errMSG", "데이터베이스 수정실패");
				request.setAttribute("url", "main.jsp");
				RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}