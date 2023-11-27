package mvcBoard.dao;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import mvcBoard.dto.BoardDTO;

public class BoardDAO {
	private static BoardDAO boardDAO = new BoardDAO();
	private DataSource dataSource;
	public BoardDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/myjsp");
		}catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static BoardDAO getBoardDAO() {
		return boardDAO;
	}
	
	public ArrayList<BoardDTO> selectAll() {
		String sql = "select * from mvcboard order by groupNum desc, indentNum asc, no desc";
		ArrayList<BoardDTO> list = new ArrayList<>();
		try(Connection conn = dataSource.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()){
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setName(rs.getString("name"));
				dto.setWtime(rs.getString("wtime"));
				dto.setHit(rs.getInt("hit"));
				list.add(dto);
				
			}
		}catch(SQLException E) {
					E.printStackTrace();
				}
		return list;
	}
	
	public int getCurrentNum(BoardDTO dto) {
		String sql = "select max(no) from mvcboard where name = '" + dto.getName() + "'";
		int curNum=0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()){
			if(rs.next())
				curNum = rs.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return curNum;
	}
	
	public void updateGroupNum(int curNum) {
		String sql = "update mvcboard set groupnum=? where no = ?";
		int result=0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, curNum);
			ps.setInt(2, curNum);
			result = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertNew(BoardDTO dto) {
		String sql = "insert into mvcboard (name,title,contents) values(?,?,?)";
		int curNum=0;
		int result=0;
		try(Connection conn= dataSource.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, dto.getName());
			pst.setString(2, dto.getTitle());
			pst.setString(3, dto.getContents());
			result = pst.executeUpdate();
			curNum=getCurrentNum(dto);
			updateGroupNum(curNum);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertReply(BoardDTO dto, int pNo) {
		String sql = "insert into mvcboard (name,title,contents) values(?,?,?)";
		int curNum=0;
		int result=0;
		try(Connection conn= dataSource.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, dto.getName());
			pst.setString(2, dto.getTitle());
			pst.setString(3, dto.getContents());
			result = pst.executeUpdate();
			curNum=getCurrentNum(dto);
			parentInfo(curNum, pNo);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void parentInfo(int curNum, int pNo) {
		String sqlP = "select indentNum,groupNum from mvcboard where no="+pNo;
		String sqlC = "update mvcboard set indentNum=?, groupNum=? where no = ?";
		int iNum=0, gNum=0, result=0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sqlP);
				PreparedStatement pst = conn.prepareStatement(sqlC);
				ResultSet rs = ps.executeQuery()){
			if(rs.next()) {
				iNum = rs.getInt(1);
				gNum = rs.getInt(2);
			}	
			pst.setInt(1,iNum+1);
			pst.setInt(2,gNum);
			pst.setInt(3,curNum);
			result = pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public BoardDTO selectOne(int no) {
		String sql = "select * from mvcboard where no="+no;
		BoardDTO dto = new BoardDTO();
		try(Connection conn = dataSource.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()){
			while(rs.next()) {
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setName(rs.getString("name"));
				dto.setWtime(rs.getString("wtime"));
				dto.setHit(rs.getInt("hit"));
				dto.setContents(rs.getString("contents"));
			}
		}catch(SQLException E) {
					E.printStackTrace();
				}
		return dto;
	}
	
	public void increaseHit(int no) {
		String sql = "update mvcboard set hit=hit+1 where no="+no;
		int result = 0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql) ) {
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public BoardDTO contentView(int no){
		increaseHit(no);
		BoardDTO dto = selectOne(no);
		return dto;
	}
	
	public void deleteDAO(int no) {
		String sql = "delete from mvcboard where no="+no;
		int result = 0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql) ) {
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void modifyPost(BoardDTO dto, int no) {
		String sql = "update mvcboard set name = ? ,title= ? ,contents =?  where no=?";
		int result=0;
		try(Connection conn= dataSource.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, dto.getName());
			pst.setString(2, dto.getTitle());
			pst.setString(3, dto.getContents());
			pst.setInt(4, no);
			result = pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
