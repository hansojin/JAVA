package datotest;

import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;

public class BoardDAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/myjsp?serverTimezone=UTC";
	private String user = "root";
	private String password = "1234";
	
	public BoardDAO() {
		try {
			Class.forName(driver);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public ArrayList<BoardDTO> selectBoard(){
		String sql = "SELECT no, title, name, wtime, rcnt FROM board ORDER BY no DESC";
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		try(Connection conn = DriverManager.getConnection(url,user,password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setName(rs.getString("name"));
				dto.setWtime(rs.getString("wtime"));
				dto.setRcnt(rs.getInt("rcnt"));
				list.add(dto);	
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int insertBoardDAO(BoardDTO dto) {
		String sql = "INSERT INTO board (title, name, password, email, contents) VALUES(?, ?, ?, ?, ?)";
		int result=0;
		try(Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPassword());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getContents());
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
