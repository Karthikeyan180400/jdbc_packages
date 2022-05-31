package databasecrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import helperpackage.HelperClass;
import property.Employee;

public class EmployeeCrud {

	HelperClass helperClass = new HelperClass();
	Connection connection = helperClass.getConnection();

	public void saveEmployee(Employee employee) {
		String query = "insert into employee values(?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, employee.getId());
			preparedStatement.setString(2,employee.getName());
			preparedStatement.setString(3, employee.getEmail());
			
			preparedStatement.execute();
			System.out.println("Inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void updateEmployee(Employee employee) {
		String query = "update employee set email=? where id=?";
		
		try {
			PreparedStatement preparedStatement  = connection.prepareStatement(query);
			preparedStatement.setString(1, employee.getEmail());
			preparedStatement.setInt(2, employee.getId());
			preparedStatement.execute();
			System.out.println("Updated");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteEmployee(Employee employee) {
		String query = "delete from employee where id =?";
		
		try {
			PreparedStatement preparedStatement  = connection.prepareStatement(query);
			preparedStatement.setInt(1,employee.getId());
			preparedStatement.execute();
			System.out.println("Deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public List<Employee> printAllEmployee() {
		String query = "select * from employee";
		Employee employee =null;
		List<Employee> arrayList = new ArrayList<Employee>();
		try {
			PreparedStatement preparedStatement  = connection.prepareStatement(query);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				 employee = new Employee();
				 employee.setId(resultSet.getInt(1));
				 employee.setName(resultSet.getString(2));
				 employee.setEmail(resultSet.getString(3));
				 arrayList.add(employee);
				}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayList;
		
	}
	
	public void printEmployeeById(int id) {
		String query = "select * from employee where id=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
			    System.out.println(resultSet.getInt(1));
			    System.out.println(resultSet.getString(2));
			    System.out.println(resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
