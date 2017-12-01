package demo3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

@WebServlet("/emp.do")
public class EmployeeXmlServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Employee employee = new Employee(100, "Steven","king","AP_PRES",200000,new Date());
		
		res.setContentType("text/xml;charset=utf-8");
		PrintWriter pw = res.getWriter();
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			
			marshaller.marshal(employee, pw);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		
		/*
		StringBuilder xml = new StringBuilder();
		xml.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		xml.append("<employee>");
		xml.append("<emp_id>"+employee.getId()+"</emp_id>");
		xml.append("<first_name>"+employee.getFirstName()+"</first_name>");
		xml.append("<last_name>"+employee.getLastName()+"</last_name>");
		xml.append("<job_id>"+employee.getJobId()+"</job_id>");
		xml.append("<salary>"+employee.getSalary()+"</salary>");
		xml.append("<hire_date>"+employee.getHireDate()+"</hire_date>");
		xml.append("</employee>");
		
		pw.write(xml.toString());
		*
		*/
	}
}
