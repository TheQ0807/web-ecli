package demo3;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class EmployeeUnmarshallingSample {

	public static void main(String[] args) throws Exception {
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		
		Employee employee
			= (Employee) unmarshaller.unmarshal(new File("c:/temp/employee.xml"));
		
		System.out.println(employee);
	}
}
