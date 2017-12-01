package demo3;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class EmployeeMarshallingSample {

	public static void main(String[] args) throws Exception {
		
		Employee employee = new Employee(100, "Steven","king","AP_PRES",200000,new Date());
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		marshaller.marshal(employee, new File("c:/temp/employee.xml"));
	}
}
