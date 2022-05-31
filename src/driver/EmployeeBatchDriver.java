package driver;

import java.util.ArrayList;

import batch.EmployeeBatchExecution;
import property.Employee;

public class EmployeeBatchDriver {
	public static void main(String[] args) {
		
		ArrayList<Employee> list = new ArrayList<Employee>();
		Employee e1 = new Employee();
		e1.setId(7);
		e1.setName("Abhijeeth");
		e1.setEmail("abi@mail.com");
		
		Employee e2 = new Employee();
		e2.setId(8);
		e2.setName("Mohamood");
		e2.setEmail("mahamood@mail.com");
		
		Employee e3 = new Employee();
		e3.setId(9);
		e3.setName("Chimgond");
		e3.setEmail("chimgond@mail.com");
		
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		EmployeeBatchExecution e = new EmployeeBatchExecution();
		e.employeeExecution(list);
		
		
		
		
		
		
		
	}

}
