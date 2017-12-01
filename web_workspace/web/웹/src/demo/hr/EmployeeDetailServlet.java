package demo.hr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/empDetail.hta")
public class EmployeeDetailServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("empid"));
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		pw.println("<!DOCTYPE html>");
		pw.println("<html lang='ko'>");
		pw.println("<head>");
		pw.println("<meta charset='utf-8'>");
		pw.println("<title>사원 정보</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h1>사원 상세 정보</h1>");
		pw.println("<table border='1' width='100%'>");
		
		try {
		EmployeeDao dao = new EmployeeDao();
		Employee emp = dao.getEmployeeById(id);
			if (emp !=null) {
				pw.println("<tr><th>emp id</th><td>"+emp.getId()+"</td></tr>");
				pw.println("<tr><th>first name</th><td>"+emp.getFirstName()+"</td></tr>");
				pw.println("<tr><th>last name</th><td>"+emp.getLastName()+"</td></tr>");
				pw.println("<tr><th>email</th><td>"+emp.getEmail()+"</td></tr>");
				pw.println("<tr><th>phone</th><td>"+emp.getPhoneNumber()+"</td></tr>");
				pw.println("<tr><th>hire date</th><td>"+emp.getHireDate()+"</td></tr>");
				pw.println("<tr><th>salary</th><td>"+emp.getSalary()+"</td></tr>");
				pw.println("<tr><th>department</th><td>"+emp.getDepartmentId()+"</td></tr>");
			}
		
		} catch (Exception e){
			e.printStackTrace();
			
		}
		
		pw.println("</table>");
		
		pw.println("<p><a href='empList.hta'>List</a></p>");
		
		pw.println("</body>");
		pw.println("</html>");
		
	}
}
