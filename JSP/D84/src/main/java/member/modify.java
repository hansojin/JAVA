package member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/modify")
public class modify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public modify() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String name = request.getParameter("name");
        String id = request.getParameter("id");
        String password = request.getParameter("pw");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String[] hobbies = request.getParameterValues("hobby");
        String numFront = request.getParameter("numFront");
        String number = request.getParameter("number");
        
        boolean done = updateDB(name,id,password,gender,email,hobbies,numFront,number);
        if (done) {
        	response.sendRedirect("member/main.jsp");
		}else {
			response.sendRedirect("member/error.jsp");
		}
		
	}
	
	private boolean updateDB(String name, String id, String password, String gender, String email, String[] hobbies, String numFront, String number) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/hellojsp?serverTimezone=UTC";
		String mysqlId = "root";
		String mysqlPw = "1234";
		
		try{
			Class.forName(driver);		
		} catch(ClassNotFoundException e){
			System.out.println("드라이버 로드 실패");
		}
		String sql = "update member set gender=?, email=?, hobby=?, phonePre=?, phoneElse=? where id=? and pw=?";
		int res=0;
		try (Connection conn = DriverManager.getConnection(url, mysqlId, mysqlPw);
		         PreparedStatement st = conn.prepareStatement(sql)) {

		        st.setString(1, gender);
		        st.setString(2, email);
		        st.setString(3, String.join(",", hobbies)); 
		        st.setString(4, numFront);
		        st.setString(5, number);
		        st.setString(6, id);
		        st.setString(7, password);

		        res = st.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return res>0;
	}

}
