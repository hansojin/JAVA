package mvc2.dao;

import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.DataSource;
import mvc2.dto.BulletinDTO;

public class BulletinDAO {
	private static BulletinDAO bDAO = new BulletinDAO();
	private DataSource dataSource;	
	
	private BulletinDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/myjsp");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static BulletinDAO getBDAO() {
		return bDAO;
	}
	
	public BulletinDTO getBDTO(int no) {
		final String sql = "select * from Bulletin where no = "+ no;
		BulletinDTO dto = new BulletinDTO();
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			if(rs.next()){
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setTel(rs.getString("tel"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setContents(rs.getString("contents"));
				dto.setHit(rs.getInt("hit"));
				dto.setWtime(rs.getString("wtime"));
				dto.setGroupNum(rs.getInt("groupNum"));
				dto.setIndentNum(rs.getInt("indentNum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
		return dto;
	}
	
	public ArrayList<BulletinDTO> selectAll(){
		ArrayList<BulletinDTO> list = new ArrayList<BulletinDTO>();
		final String sql = "SELECT * FROM bulletin order by GROUPNUM DESC, indentNum ASC, no DESC";


		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()){
			while(rs.next()) {
				BulletinDTO dto = new BulletinDTO();
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setTel(rs.getString("tel"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setContents(rs.getString("contents"));
				dto.setHit(rs.getInt("hit"));
				dto.setWtime(rs.getString("wtime"));
				dto.setGroupNum(rs.getInt("groupNum"));
				dto.setIndentNum(rs.getInt("indentNum"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<BulletinDTO> selectPost(String sBox, String sBar){
		ArrayList<BulletinDTO> list = new ArrayList<BulletinDTO>();
		String sql = "SELECT * FROM bulletin WHERE ";
		if ("title".equals(sBox)) {
			sql += "title LIKE '%" + sBar + "%'";
		} else if ("titleCon".equals(sBox)) {
			sql += "title = '" + sBar + "' OR contents LIKE '%" + sBar + "%'";
		} else if ("writer".equals(sBox)) {
			sql +=  "id = '" + sBar + "'";
		}
		sql+=" ORDER BY GROUPNUM DESC, indentNum ASC, no DESC";
		System.out.println(sql);
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()){
			while(rs.next()) {
				BulletinDTO dto = new BulletinDTO();
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setTel(rs.getString("tel"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setContents(rs.getString("contents"));
				dto.setHit(rs.getInt("hit"));
				dto.setWtime(rs.getString("wtime"));
				dto.setGroupNum(rs.getInt("groupNum"));
				dto.setIndentNum(rs.getInt("indentNum"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public int getCurrentNum(BulletinDTO dto) {	
		final String sql = "SELECT MAX(NO) FROM bulletin WHERE ID = '" + dto.getId() + "'";
		int curNum = 0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			if(rs.next()) curNum = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return curNum;
	}
	
	public void updateGroupNum(int curNum) {	
		final String sql = "UPDATE bulletin SET GROUPNUM = ? WHERE NO = ?";
		int result = 0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, curNum);
			ps.setInt(2, curNum);
			result = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateWriterInfo(Connection conn, String id, int curNum) {
	    final String memberSql = "SELECT NAME, TEL FROM member WHERE ID = ?";
	    final String bulletinUpdateSql = "UPDATE bulletin SET NAME = ?, TEL = ? WHERE NO = ?";
	    
	    try (PreparedStatement memberPs = conn.prepareStatement(memberSql);
	         PreparedStatement bulletinUpdatePs = conn.prepareStatement(bulletinUpdateSql)) {
	        memberPs.setString(1, id);
	        try (ResultSet rs = memberPs.executeQuery()) {
	            if (rs.next()) {
	                String name = rs.getString("NAME");
	                String tel = rs.getString("TEL");

	                bulletinUpdatePs.setString(1, name);
	                bulletinUpdatePs.setString(2, tel);
	                bulletinUpdatePs.setInt(3, curNum);
	                bulletinUpdatePs.executeUpdate();
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void writeOK(BulletinDTO dto) {	
		final String sql = 
				"INSERT INTO bulletin (ID, TITLE, CONTENTS) values(?, ?, ?)";
		int curNum = 0;
		int result = 0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getTitle());
			ps.setString(3, dto.getContents());
			result = ps.executeUpdate();
			curNum = getCurrentNum(dto);
			updateGroupNum(curNum);
			updateWriterInfo(conn, dto.getId(), curNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void increaseHit(int no) {
		final String sql = 
				"UPDATE bulletin SET HIT=HIT+1 WHERE no=" + no;
		int result = 0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql) ) {
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public BulletinDTO viewContent(int no) {
		increaseHit(no);
		BulletinDTO dto = getBDTO(no);
		return dto;
	}
	
	public void modifyOK(BulletinDTO dto, int no) {
		final String sql = 
				"UPDATE bulletin SET TITLE=?, CONTENTS=?, WTIME=NOW() WHERE no=?";
		int result = 0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getContents());
			ps.setInt(3, no);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void deletePost(int no) {
		final String sql =
				"DELETE FROM bulletin WHERE no=?";
		int result = 0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, no);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public BulletinDTO replyView(int no) {
		BulletinDTO dto = getBDTO(no);
		return dto;
	}
	
	public void replyOK(BulletinDTO dto) {
		final String sql = 
				"INSERT INTO bulletin (ID, TEL, NAME, TITLE, CONTENTS, GROUPNUM, INDENTNUM) values(?, ?, ?, ?, ?, ?, ?)";
		int result = 0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getTel());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getTitle());
			ps.setString(5, dto.getContents());
			ps.setInt(6, dto.getGroupNum());
			ps.setInt(7, dto.getIndentNum()+1);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	
	
}
