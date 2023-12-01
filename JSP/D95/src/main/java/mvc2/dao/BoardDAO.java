package mvc2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import mvc2.dto.BoardDTO;

public class BoardDAO {
	private static BoardDAO boardDAO = new BoardDAO();
	private int sizeOfPage = 5;
	private String CONNECTION_POOL_RESOURCE_NAME = "jdbc/myjsp";
	private final String BOARD_TABLE_NAME = "memboard";
	private final String MEMBER_TABLE_NAME = "mem";
	private DataSource dataSource;
	private final String GET_BOARD_DTO_SQL = "SELECT m.*, mb.* FROM " + BOARD_TABLE_NAME + " mb JOIN " + MEMBER_TABLE_NAME + " m" + " ON mb.no = ? WHERE m.id = ?";
	private final String SELECT_ALL_BOARD_SQL = "SELECT * FROM " + BOARD_TABLE_NAME + " order by GROUPNUM DESC, STEPNUM ASC LIMIT ?, ?";
	private final String INSERT_BOARD_SQL = 
			"INSERT INTO " + BOARD_TABLE_NAME + " (ID, TITLE, CONTENTS, GROUPNUM) values(?, ?, ?, ?)";
	private final String GET_CURRENT_NUM_SQL = "SELECT MAX(no) from " + BOARD_TABLE_NAME;
	private final String INCREASE_HIT_SQL = 
			"UPDATE " + BOARD_TABLE_NAME + " SET HIT=HIT+1 WHERE no=?";
	private final String UPDATE_BOARD_SQL = 
			"UPDATE " + BOARD_TABLE_NAME + " SET CONTENTS=?, WTIME=NOW() WHERE no=?";
	private final String UPDATE_STEP_NUM_SQL = 
			"UPDATE " + BOARD_TABLE_NAME + " SET STEPNUM=STEPNUM+1 WHERE GROUPNUM=? AND STEPNUM>=?";
	private final String INSERT_REPLY_SQL = 
			"INSERT INTO " + BOARD_TABLE_NAME + " (ID, TITLE, CONTENTS, GROUPNUM, STEPNUM, INDENTNUM) values(?, ?, ?, ?, ?, ?)";
	private final String DELETE_SQL =
			"DELETE FROM " + BOARD_TABLE_NAME + " WHERE no=?";
	private final String SEARCH_BOARD_SQL_BY_ID = "SELECT * FROM " + BOARD_TABLE_NAME + " WHERE ID LIKE ? order by GROUPNUM DESC, STEPNUM ASC";
	private final String SEARCH_BOARD_SQL_BY_TITLE = "SELECT * FROM " + BOARD_TABLE_NAME + " WHERE TITLE LIKE ? order by GROUPNUM DESC, STEPNUM ASC";
	private final String SEARCH_BOARD_SQL_BY_TITLE_AND_CONTENTS = "SELECT * FROM " + BOARD_TABLE_NAME + " WHERE TITLE LIKE ? OR CONTENTS LIKE ? order by GROUPNUM DESC, STEPNUM ASC";
	private final String SELECT_COUNT_OF_LIST = "SELECT COUNT(*) FROM " + BOARD_TABLE_NAME;
	
	private BoardDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/" + CONNECTION_POOL_RESOURCE_NAME);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static BoardDAO getBoardDAO() {
		return boardDAO;
	}
	
	public BoardDTO getBoardDTO(BoardDTO dto) {
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(GET_BOARD_DTO_SQL)) {
			ps.setInt(1, dto.getNo());
			ps.setString(2, dto.getId());
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()){
					dto.setNo(rs.getInt("no"));
					dto.setId(rs.getString("id"));
					dto.setNickname(rs.getString("nickname"));
					dto.setName(rs.getString("name"));
					dto.setCellphone(rs.getString("cellphone"));
					dto.setTitle(rs.getString("title"));
					dto.setContents(rs.getString("contents"));
					dto.setHit(rs.getInt("hit"));
					dto.setWtime(rs.getString("wtime"));
					dto.setGroupNum(rs.getInt("groupNum"));
					dto.setStepNum(rs.getInt("stepNum"));
					dto.setIndentNum(rs.getInt("indentNum"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return dto;
	}
	
	public void increaseHit(int no) {
		int result = 0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(INCREASE_HIT_SQL)) {
			ps.setInt(1, no);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getCurrentNum() {
		int curNum = 0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps =conn.prepareStatement(GET_CURRENT_NUM_SQL);
				ResultSet rs = ps.executeQuery()){
			if(rs.next()) {
				curNum = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return curNum + 1;
	}
	
	public void writeOKDAO(BoardDTO dto) {
		int curNum = getCurrentNum();
		int result = 0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(INSERT_BOARD_SQL)) {
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getTitle());
			ps.setString(3, dto.getContents());
			ps.setInt(4, curNum);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public void modifyOK(BoardDTO dto) {
		int result = 0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(UPDATE_BOARD_SQL)){
			ps.setString(1, dto.getContents());
			ps.setInt(2, dto.getNo());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public void updateStepNum(BoardDTO dto) {
		int result = 0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(UPDATE_STEP_NUM_SQL)) {
			ps.setInt(1, dto.getGroupNum());
			ps.setInt(2, dto.getStepNum()+1);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public BoardDTO replyDAO(BoardDTO dto) {
		getBoardDTO(dto);		
		return dto;
	}
	
	public void replyOKDAO(BoardDTO dto) {
		updateStepNum(dto);
		int result = 0;
		try(Connection conn = dataSource.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(INSERT_REPLY_SQL)){
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getTitle());
			ps.setString(3, dto.getContents());
			ps.setInt(4, dto.getGroupNum());
			ps.setInt(5, dto.getStepNum()+1);
			ps.setInt(6, dto.getIndentNum()+1);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
	}
	
	public void deleteDAO(int no) {
		int result = 0;
		try(Connection conn = dataSource.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(DELETE_SQL)){
			ps.setInt(1, no);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	public int cntOfList() {
		int cnt = 0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(SELECT_COUNT_OF_LIST);
				ResultSet rs = ps.executeQuery()){
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
		return cnt;
	}
	
	public int calTotalPage() {
		int numberOfArticles = cntOfList();
		int totalPage = numberOfArticles / sizeOfPage;
		if(numberOfArticles != 0)
			totalPage = numberOfArticles % sizeOfPage == 0 ? totalPage-1 : totalPage;
		
		return totalPage;
	}
	
	public ArrayList<BoardDTO> listDAO(int curPage){
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(SELECT_ALL_BOARD_SQL)) {
			ps.setInt(1, curPage*sizeOfPage);
			ps.setInt(2, sizeOfPage);
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					BoardDTO dto = new BoardDTO();
					dto.setNo(rs.getInt("no"));
					dto.setId(rs.getString("id"));
					dto.setTitle(rs.getString("title"));
					dto.setContents(rs.getString("contents"));
					dto.setHit(rs.getInt("hit"));
					dto.setWtime(rs.getString("wtime"));
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
	
	public BoardDTO viewDAO(BoardDTO dto) {
		increaseHit(dto.getNo());
		dto = getBoardDTO(dto);
		return dto;
	}

	public ArrayList<BoardDTO> search(String kindOfSearch, String searchKeyword) {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		try(Connection conn = dataSource.getConnection()){
			String sql = null;
			if(kindOfSearch.equals("searchId")){
				sql = SEARCH_BOARD_SQL_BY_ID;
			} else if(kindOfSearch.equals("searchTitle")){
				sql = SEARCH_BOARD_SQL_BY_TITLE;
			} else if(kindOfSearch.equals("searchTitleAndContents")){
				sql = SEARCH_BOARD_SQL_BY_TITLE_AND_CONTENTS;
			}
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				if(kindOfSearch.equals("searchId") || kindOfSearch.equals("searchTitle")) {
					ps.setString(1, "%" + searchKeyword + "%");
				} else if(kindOfSearch.equals("searchTitleAndContents")){
					ps.setString(1, "%" + searchKeyword + "%");
					ps.setString(2, "%" + searchKeyword + "%");					
				}
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						BoardDTO dto = new BoardDTO();
						dto.setNo(rs.getInt("no"));
						dto.setId(rs.getString("id"));
						dto.setTitle(rs.getString("title"));
						dto.setContents(rs.getString("contents"));
						dto.setHit(rs.getInt("hit"));
						dto.setWtime(rs.getString("wtime"));
						dto.setGroupNum(rs.getInt("groupNum"));
						dto.setStepNum(rs.getInt("stepNum"));
						dto.setIndentNum(rs.getInt("indentNum"));
						list.add(dto);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return list;
	}
}