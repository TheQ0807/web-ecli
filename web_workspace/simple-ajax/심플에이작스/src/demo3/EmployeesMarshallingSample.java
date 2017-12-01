package demo3;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class EmployeesMarshallingSample {

	public static void main(String[] args) throws Exception {
		
		List<Employee> list = Arrays.asList(
			new Employee(100, "Steven","king","AP_PRES",200000,new Date()),
			new Employee(100, "Steven","king","AP_PRES",200000,new Date()),
			new Employee(100, "Steven","king","AP_PRES",200000,new Date()),
			new Employee(100, "Steven","king","AP_PRES",200000,new Date())				
		);
		Employees employees = new Employees();
		employees.setEmployeeList(list);
				
		JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		marshaller.marshal(employees, System.out);
	}
}
