package mvc2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import mvc2.dto.MemberDTO;

public class MemberDAO {
	private static MemberDAO mDAO = new MemberDAO();
	private DataSource dataSource;	
	
	private MemberDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/myjsp");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDAO getMDAO() {
		return mDAO;
	}
	
	public MemberDTO getMDTO(String id) {
		final String sql = "select * from Member where id = '"+ id + "'";
		MemberDTO dto = new MemberDTO();
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			if(rs.next()){
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setNickname(rs.getString("nickname"));
				dto.setTel(rs.getString("tel"));
				dto.setEmail(rs.getString("email"));
				dto.setPostcode(rs.getString("postcode"));
				dto.setRoadAddress(rs.getString("roadAddress"));
				dto.setJibunAddress(rs.getString("jibunAddress"));
				dto.setDetailAddress(rs.getString("detailAddress"));
				dto.setExtraAddress(rs.getString("extraAddress"));
				dto.setbYear(rs.getString("bYear"));
				dto.setbMonth(rs.getString("bMonth"));
				dto.setbDay(rs.getString("bDay"));
				dto.setSex(rs.getString("sex"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
		return dto;
	}
	
	public void memberRegister(MemberDTO dto) {	
		final String sql = 
				"INSERT INTO member values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int result = 0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getId());
			ps.setString(3, dto.getPw());
			ps.setString(4, dto.getNickname());
			ps.setString(5, dto.getTel());
			ps.setString(6, dto.getEmail());
			ps.setString(7, dto.getPostcode());
			ps.setString(8, dto.getRoadAddress());
			ps.setString(9, dto.getJibunAddress());
			ps.setString(10, dto.getDetailAddress());
			ps.setString(11, dto.getExtraAddress());
			ps.setString(12, dto.getbYear());
			ps.setString(13, dto.getbMonth());
			ps.setString(14, dto.getbDay());
			ps.setString(15, dto.getSex());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void modifyInfo(MemberDTO dto) {
		final String sql = 
				"UPDATE member SET pw=?,nickname=?,tel=?,email=?,postcode=?,roadAddress=?,jibunAddress=?,detailAddress=?,extraAddress=?,bYear=?,bMonth=?,bDay=?,sex=? WHERE id=?";
		int result = 0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, dto.getPw());
			ps.setString(2, dto.getNickname());
			ps.setString(3, dto.getTel());
			ps.setString(4, dto.getEmail());
			ps.setString(5, dto.getPostcode());
			ps.setString(6, dto.getRoadAddress());
			ps.setString(7, dto.getJibunAddress());
			ps.setString(8, dto.getDetailAddress());
			ps.setString(9, dto.getExtraAddress());
			ps.setString(10, dto.getbYear());
			ps.setString(11, dto.getbMonth());
			ps.setString(12, dto.getbDay());
			ps.setString(13, dto.getSex());
			ps.setString(14, dto.getId());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void loginCheck(String id, String pw, HttpSession session) {
		final String sql = "select count(*) from member where id = ? and pw = ?";

		int result = 0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, id);
			ps.setString(2, pw);
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()){
					int cnt=rs.getInt(1);
					if (cnt==1)
						session.setAttribute("id", id);
					else
						session.setAttribute("loginError", "true");			
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void idCheck(String id, HttpSession session) {
		final String sql = "select count(*) from member where id = ?";

		int result = 0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, id);
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()){
					int cnt=rs.getInt(1);
					if (cnt==1)
						session.setAttribute("hasID", "true");			
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public MemberDTO selectInfo(String id){
		MemberDTO dto = getMDTO(id);
		System.out.println(id);
		System.out.println(dto.getTel());
		return dto;
		
	}
	
	
}
