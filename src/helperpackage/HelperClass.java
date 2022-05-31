package helperpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HelperClass {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/javabatch";
	String user = "root";
	String password = "root";
	Connection connection = null;
	
	public Connection getConnection() {
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
		
	}

}
