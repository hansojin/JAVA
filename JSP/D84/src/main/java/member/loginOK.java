package member;

import java.io.IOException;
import java.sql.* ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginOK")
public class loginOK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public loginOK() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		boolean isUser = checkLogin(id,password);
		HttpSession session = request.getSession();
		if (isUser) {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			session.setAttribute("id", request.getParameter("id"));
		}else {
			session.setAttribute("loginFailed", true);
		}
		response.sendRedirect("member/main.jsp");
	}
	
	private boolean checkLogin(String userID, String userPW) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/hellojsp?serverTimezone=UTC";
		String mysqlId = "root";
		String mysqlPw = "1234";
		
		try{
			Class.forName(driver);		
		} catch(ClassNotFoundException e){
			System.out.println("드라이버 로드 실패");
		}
		String sql = "select count(*) from member where id='"+userID + "'and pw='"+ userPW+"'";
		int cnt=0;
		try(Connection conn = DriverManager.getConnection(url, mysqlId, mysqlPw);
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql)){
			if(rs.next())
				cnt=rs.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if (cnt!=0)
			return true;
		else
			return false;
	}

}
