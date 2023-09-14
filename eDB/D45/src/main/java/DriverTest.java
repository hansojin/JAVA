import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverTest {
	public static void main(String[] args) {
		Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/project?serverTimezone=UTC", 
                    "root", "1234");  
            System.out.println("Success");
        }
        catch(SQLException ex){ 
            System.out.println("SQLException" + ex);
            ex.printStackTrace();
        }
        catch(Exception ex){ 
            System.out.println("Exception:" + ex);
            ex.printStackTrace();
        }
	}

}
