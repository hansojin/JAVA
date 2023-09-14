package queryTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest2 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/projectInsert?serverTimezone=UTC";
		String id = "root", pw = "1234";

		String name = null, title = null, contents = null, wTime = null;
		int menu=0, result = 0, no=0, rCnt=0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

		try(Connection conn = DriverManager.getConnection(url,id,pw)){
			System.out.println("success");
			Scanner sc = new Scanner(System.in);

			while(true) {
				System.out.println("Choose option");
				System.out.println("1. WRITE");
				System.out.println("2. READ");
				System.out.println("3. MODIFY");
				System.out.println("4. DELETE");
				System.out.println("5. EXIT");
				System.out.print("Enter number : ");
				menu = sc.nextInt();
				sc.nextLine();
				switch(menu){
				case 1:
					String sqlInsert = "insert into board(name,title,contents) values (?,?,?)";
					
					try(PreparedStatement pstmt1 = conn.prepareStatement(sqlInsert)){
						System.out.print("Name : ");
						name = sc.nextLine();
						System.out.print("Title: ");
						title = sc.nextLine();
						System.out.print("Contents : ");
						contents = sc.nextLine();

						pstmt1.setString(1, name);
						pstmt1.setString(2, title);
						pstmt1.setString(3, contents);
						result = pstmt1.executeUpdate();
						
						if (result>0)
							System.out.println("inserted\n");

					}catch(SQLException e) {
						e.printStackTrace();
					}
					break;
					
				case 2:
					String sqlSelect = "select * from board order by no desc";
					
					try(Statement stmt = conn.createStatement();
							ResultSet rs = stmt.executeQuery(sqlSelect)){
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
					}catch(SQLException e) {
						e.printStackTrace();
					}
					break;
					
				case 3:
					String sqlModify = "update board set contents=? where no=?";

					try(PreparedStatement pstM = conn.prepareStatement(sqlModify)){
						System.out.print("Enter no to modify : ");
						no=sc.nextInt();
						sc.nextLine();
						System.out.print("Enter contents : ");
						contents = sc.nextLine();

						pstM.setString(1,contents);
						pstM.setInt(2, no);
						result = pstM.executeUpdate();

						if (result>0)
							System.out.println("modified\n");
					}catch (SQLException e) {
						e.printStackTrace();
					}
					break;
					
				case 4:
					String sqlDelete = "delete from board where no=?";
					
					try(PreparedStatement pstD = conn.prepareStatement(sqlDelete)){
						System.out.print("Enter no to delete : "); 
						no=sc.nextInt();
						sc.nextLine();

						pstD.setInt(1, no);
						result= pstD.executeUpdate();
						
						if (result>0)
							System.out.println("deleted\n");
					}catch(SQLException e) {
						e.printStackTrace();
					}
					break;
					
				case 5:
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

