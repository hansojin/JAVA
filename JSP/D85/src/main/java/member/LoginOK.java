package member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginOK")
public class LoginOK extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginOK() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String driver = "com.mysql.cj.jdbc.Driver";
		String mysqlUrl = "jdbc:mysql://localhost:3306/hellojsp?serverTimezone=UTC";
		String mysqlUser = "root";
		String mysqlPassword = "1234";
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPassword);
				PreparedStatement pstmt = conn.prepareStatement("SELECT ID, PASSWORD FROM MEMBER2 WHERE ID=? AND PASSWORD=?") ){
			pstmt.setString(1,  id);
			pstmt.setString(2,  password);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()){
					session.setAttribute("id", id);
					response.sendRedirect("main.jsp");
				} else{
					request.setAttribute("errMSG", "유효하지 않은 아이디와 비밀번호 입니다.");
					request.setAttribute("url", "main.jsp");
					RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
					dispatcher.forward(request, response);				
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}