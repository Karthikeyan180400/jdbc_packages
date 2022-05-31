package ty1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import helperpackage.HelperClass;

public class StudentCrud {
	HelperClass helperClass = new HelperClass();

	public void saveStudent(int id,String name,String password) {
		Connection connection=null; 
		String query = "insert into student values(?,?,?)";
		
		try {
			//System.out.println(10/0);
			connection = helperClass.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, password);
			
			preparedStatement.execute();
			
			connection.close();
			
			System.out.println("Inserted");
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				if(connection!=null) {
					connection.close();
					//System.out.println("Closed");
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
