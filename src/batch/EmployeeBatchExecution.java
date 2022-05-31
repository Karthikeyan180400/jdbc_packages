package batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import helperpackage.HelperClass;
import property.Employee;

public class EmployeeBatchExecution {
	HelperClass helperClass = new HelperClass();
	Connection connection = helperClass.getConnection();
	public void employeeExecution(List<Employee> list) {
		String query ="insert into employee values(?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			for(Employee employee:list) {
				preparedStatement.setInt(1,employee.getId());
				preparedStatement.setString(2,employee.getName());
				preparedStatement.setString(3, employee.getEmail());
				
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
			System.out.println("Employee Saved");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
