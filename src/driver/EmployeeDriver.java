package driver;

import databasecrud.EmployeeCrud;
import property.Employee;

public class EmployeeDriver {

	public static void main(String[] args) {
		Employee employee = new Employee();
		//employee.setId(6);
		//employee.setName("Eeshawaran");
		//employee.setEmail("eeshwaran@mail.com");
		//employee.setId(5);
		//employee.setEmail("murali@mail.com");
		//employee.setId(4);
		EmployeeCrud employeeCrud = new EmployeeCrud();
		//employeeCrud.saveEmployee(employee);
		//employeeCrud.updateEmployee(employee);
		//employeeCrud.deleteEmployee(employee);
		//System.out.println(employeeCrud.printAllEmployee());
		employeeCrud.printEmployeeById(6);
        		

	}

}
