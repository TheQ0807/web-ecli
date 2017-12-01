package demo3;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class EmployeeXmlParser {

	public static void main(String[] args) throws Exception {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("c:/temp/employee.xml"));
		
		String id = document.getElementsByTagName("emp_id").item(0).getTextContent();
		String firstName = document.getElementsByTagName("first_name").item(0).getTextContent();
		String lastName = document.getElementsByTagName("last_name").item(0).getTextContent();
		String jobId = document.getElementsByTagName("job_id").item(0).getTextContent();
		String salary = document.getElementsByTagName("salary").item(0).getTextContent();
		String hireDate = document.getElementsByTagName("hire_date").item(0).getTextContent();
		
		System.out.println(id);
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(jobId);
		System.out.println(salary);
		System.out.println(hireDate);
	}
}
