package ystd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/projectInsert?serverTimezone=UTC";
		String id = "root", pw = "1234";

		String name = null, title = null, contents = null, wTime = null;
		int menu = 0, result = 0, no=0, rCnt=0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sqlI = "insert into board(name,title,contents) values(?,?,?)";
		String sqlU = "update board set contents=? where no=?";
		String sqlE = null;
		
		try(Connection conn = DriverManager.getConnection(url,id,pw);
				Statement stmt = conn.createStatement();
				PreparedStatement psI = conn.prepareStatement(sqlI);
				PreparedStatement psU = conn.prepareStatement(sqlU)
			){
			Scanner sc = new Scanner(System.in);
			while(true) {
				System.out.println("Choose option");
				System.out.println("1. WRITE");
				System.out.println("2. READ");
				System.out.println("3. MODIFY");
				System.out.println("4. DELETE");
				System.out.println("5. create table test");
				System.out.println("6. drop table test");
				System.out.println("7. EXIT");
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
					
					psI.setString(1, name);
					psI.setString(2, title);
					psI.setString(3, contents);
					
					result = psI.executeUpdate();
					if(result>0)
						System.out.println("inserted");
					break;
				case 2:
					sqlE = "select * from board order by no desc";
					try(ResultSet rs = stmt.executeQuery(sqlE)){
						while (rs.next()) {
							no = rs.getInt("no");
							name = rs.getString("name");
							title = rs.getString("title");
							contents = rs.getString("contents");
							wTime = rs.getString("wTime");
//							rCnt = rs.getInt("rCnt");
							rCnt = rs.getInt(6);
							
							System.out.println("번호 " + no);
							System.out.println("이름 " + name);
							System.out.println("제목 " + title);
							System.out.println("내용 " + contents);
							System.out.println("시간 " + wTime);
							System.out.println("조회수 " + rCnt);
							System.out.println();
						}
					}catch(SQLException e) {
						e.printStackTrace();
					}							
					break;
				case 3:
					System.out.print("Enter no. to modify : ");
					no=sc.nextInt();
					sc.nextLine();
					System.out.print("Enter contents to modify : ");
					contents = sc.nextLine();
					
					psU.setString(1, contents);
					psU.setInt(2, no);
					result = psU.executeUpdate();
					if (result>0)
						System.out.println("modified");
					break;
				case 4:
					System.out.print("Enter no. to delete : ");
					no=sc.nextInt();
					sc.nextLine();
					
					sqlE = "delete from board where no="+ no;
					result = stmt.executeUpdate(sqlE);
					if (result>0)
						System.out.println("deleted");
					break;
				case 5:
					sqlE = "create table test(no int)";
					stmt.executeUpdate(sqlE);
					System.out.println("created");
					break;
				case 6:
					sqlE = "drop table test";
					stmt.executeUpdate(sqlE);
					System.out.println("deleted");
					break;
				case 7:
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
