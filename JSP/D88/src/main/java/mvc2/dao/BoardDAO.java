package mvc2.dao;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import mvc2.dto.BoardDTO;

public class BoardDAO {
	
	private DataSource dataSource;
	
	public BoardDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/myjsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BoardDTO> selectDAO(){
		String sql = "SELECT no, title, name, wtime, hit,groupNum,stepNum,indentNum FROM mvcboard ORDER BY groupNum DESC, indentNum ASC, no DESC";
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setName(rs.getString("name"));
				dto.setWtime(rs.getString("wtime"));
				dto.setHit(rs.getInt("hit"));
				list.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int insertDAO(BoardDTO dto) {
		int result=0;
		String sql = "INSERT INTO mvcboard (name, title, contents) VALUES(?, ?, ?)";
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContents());
			result = pstmt.executeUpdate();
			try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                int autoNo = generatedKeys.getInt(1);
	                System.out.println(autoNo);
	                updateGroupNum(conn, autoNo);
	            } else {
	                throw new SQLException("update groupNum==no failed");
	            }
	        }
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private void updateGroupNum(Connection conn, int autoNo) throws SQLException {
	    String updateGroupNumSql = "UPDATE mvcboard SET groupNum = ? WHERE no = ?";
	    try (PreparedStatement pstmtUpdateGroupNum = conn.prepareStatement(updateGroupNumSql)) {
	        pstmtUpdateGroupNum.setInt(1, autoNo);
	        pstmtUpdateGroupNum.setInt(2, autoNo);
	        pstmtUpdateGroupNum.executeUpdate();
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	}
	
	public ArrayList<BoardDTO> selectOne(int no) {
	    String sqlUpdate = "UPDATE mvcboard SET hit = hit + 1 WHERE no = ?";
	    String sqlSelect = "SELECT no, title, name, wtime, contents, hit, groupNum, stepNum, indentNum FROM mvcboard WHERE no = ?";
	    ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();

	    try (
	        Connection conn = dataSource.getConnection();
	        PreparedStatement pstmtUpdate = conn.prepareStatement(sqlUpdate);
	        PreparedStatement pstmtSelect = conn.prepareStatement(sqlSelect)) {
	        pstmtUpdate.setInt(1, no);
	        pstmtUpdate.executeUpdate();

	        pstmtSelect.setInt(1, no);
	        try (ResultSet rs = pstmtSelect.executeQuery()) {
	            while (rs.next()) {
	                BoardDTO dto = new BoardDTO();
	                dto.setNo(rs.getInt("no"));
	                dto.setTitle(rs.getString("title"));
	                dto.setContents(rs.getString("contents"));
	                dto.setName(rs.getString("name"));
	                dto.setWtime(rs.getString("wtime"));
	                dto.setHit(rs.getInt("hit"));
	                dto.setGroupNum(rs.getInt("groupNum"));
	                dto.setStepNum(rs.getInt("stepNum"));
	                dto.setIndentNum(rs.getInt("indentNum"));
	                list.add(dto);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return list;
	}

	public int deleteDAO(int no) {
		int result=0;
		String sql = "delete from mvcboard where no=?";
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int modifyDAO(BoardDTO dto) {
	    int result = 0;
	    String sql = "UPDATE mvcboard SET name=?, title=?, contents=? WHERE no=?";
	    try (
	        Connection conn = dataSource.getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(sql)
	    ) {
	        pstmt.setString(1, dto.getName());
	        pstmt.setString(2, dto.getTitle());
	        pstmt.setString(3, dto.getContents());
	        pstmt.setInt(4, dto.getNo());
	        result = pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}

	public ArrayList<BoardDTO> replyDAO(int no) {
	    String sqlSelect = "SELECT no, title, name, wtime, contents, hit, groupNum, stepNum, indentNum FROM mvcboard WHERE no = ?";
	    ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
	    try (
	        Connection conn = dataSource.getConnection();
	        PreparedStatement pstmtSelect = conn.prepareStatement(sqlSelect)) {
	        pstmtSelect.setInt(1, no);
	        try (ResultSet rs = pstmtSelect.executeQuery()) {
	            while (rs.next()) {
	                BoardDTO dto = new BoardDTO();
	                dto.setNo(rs.getInt("no"));
	                dto.setTitle(rs.getString("title"));
	                dto.setContents(rs.getString("contents"));
	                dto.setName(rs.getString("name"));
	                dto.setWtime(rs.getString("wtime"));
	                dto.setHit(rs.getInt("hit"));
	                dto.setGroupNum(rs.getInt("groupNum"));
	                dto.setStepNum(rs.getInt("stepNum"));
	                dto.setIndentNum(rs.getInt("indentNum"));
	                list.add(dto);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return list;
	}
	

	public int insertReplyDAO(BoardDTO dto) {
	    int result = 0;
	    String selectGroupNumSql = "SELECT groupNum, indentNum FROM mvcboard WHERE no = ?";
	    String insertReplySql = "INSERT INTO mvcboard (name, title, contents, indentNum, groupNum) VALUES (?, ?, ?, ?, ?)";
	    
	    try (
	        Connection conn = dataSource.getConnection();
	        PreparedStatement pstmtSelectGroupNum = conn.prepareStatement(selectGroupNumSql);
	        PreparedStatement pstmtInsertReply = conn.prepareStatement(insertReplySql, Statement.RETURN_GENERATED_KEYS)
	    ) {
	        pstmtSelectGroupNum.setInt(1, dto.getNo());
	        try (ResultSet rs = pstmtSelectGroupNum.executeQuery()) {
	            if (rs.next()) {
	                int parentGroupNum = rs.getInt("groupNum");
	                int parentIndentNum = rs.getInt("indentNum");

	                pstmtInsertReply.setString(1, dto.getName());
	                pstmtInsertReply.setString(2, dto.getTitle());
	                pstmtInsertReply.setString(3, dto.getContents());
	                pstmtInsertReply.setInt(4, parentIndentNum + 1);
	                pstmtInsertReply.setInt(5, parentGroupNum);

	                result = pstmtInsertReply.executeUpdate();
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return result;
	}

	
	
}
