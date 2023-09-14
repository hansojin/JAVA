package queryTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/projectInsert?serverTimezone=UTC";
		String id = "root", pw = "1234";
		
		String sql = null;
		String name = null, title = null, contents = null;
		int menu=0, result = 0;
		int  no=0, rCnt=0;
		String wTime=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(Connection conn = DriverManager.getConnection(url,id,pw);
				Statement stmt = conn.createStatement()){
			
			System.out.println("Success");
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.println("Choose option");
				System.out.println("1. WRITE");
				System.out.println("2. READ");
				System.out.println("3. EXIT");
				System.out.print("Enter number : ");
				menu = sc.nextInt();
				sc.nextLine();
				switch(menu){
				case 1:
					System.out.print("Name : ");
					name = sc.nextLine();
					System.out.print("Title: ");
					title = sc.nextLine();
					System.out.print("Contents : ");
					contents = sc.nextLine();
					
					sql = "INSERT INTO board(name, title, contents) VALUES(' "  + name + " ', '" + title + "' , '" + contents + "')";
					result = stmt.executeUpdate(sql);
					
					if (result>0)
						System.out.println(sql + " inserted");
					break;
					
				case 2:
					sql = "select * from board order by no desc";
					
					try(ResultSet rs = stmt.executeQuery(sql)){
						while(rs.next()) {
							no = rs.getInt("no");
							name = rs.getString("name");
							title= rs.getString("title");
							contents = rs.getString("contents");
							wTime = rs.getString("wTime");
							rCnt = rs.getInt("rCnt");
							
							System.out.println("번호 " + no);
							System.out.println("이름 " + name);
							System.out.println("제목 " + title);
							System.out.println("내용 " + contents);
							System.out.println("시간 " + wTime);
							System.out.println("조회수 " + rCnt);
							System.out.println();
						}
					/*
					try(ResultSet rs = stmt.executeQuery(sql)){
						ResultSetMetaData mData = rs.getMetaData();
						int columnCnt = mData.getColumnCount();
						
						while(rs.next()) {
							for (int i=1;i<=columnCnt;i++) {
								String columnName = mData.getColumnName(i);
								Object columnValue = rs.getObject(i);
								
								System.out.println(columnName + " >> " + columnValue);
							}
							
						}
					*/
					}catch(SQLException e) {
						e.printStackTrace();
					}
					
					break;
				case 3:
					System.out.println("EXIT");
					sc.close();
					return;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
