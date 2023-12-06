package shine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import shine.dto.FaceDto;

public class FaceDao {
	private static FaceDao dao = new FaceDao();
	private String CONNECTION_POOL_RESOURCE_NAME = "jdbc/myjsp";
	private final String TABLE_NAME = "face";
	private DataSource dataSource;	
	
	private FaceDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/" + CONNECTION_POOL_RESOURCE_NAME);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<FaceDto> getFace() {
		String sql = "SELECT * FROM " + TABLE_NAME;
		ArrayList<FaceDto> list = new ArrayList<>();
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
				while(rs.next()) {
					FaceDto dto = new FaceDto();
					dto.setNo(rs.getInt("no"));
					dto.setId(rs.getString("id"));
					dto.setMsg(rs.getString("msg"));
					list.add(dto);

				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static FaceDao getFaceDAO() {
		return dao;
	}
}
