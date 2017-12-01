package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import util.StringUtils;
import vo.Employee;

@WebServlet("/detail.html")
public class DetailServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int employeeId = StringUtils.strToNumber(req.getParameter("id"));
		int p = StringUtils.strToNumber(req.getParameter("p"), 1);
		
		try{
			EmployeeDao dao = new EmployeeDao();
			Employee employee = dao.getEmployeeById(employeeId);
			
			res.setContentType("text/html; charset=utf-8");
			PrintWriter pw = res.getWriter();
			pw.println("<!DOCTYPE html>");
			pw.println("<html lang='ko'>");
			pw.println("<head>");
			pw.println("<meta charset='utf-8'>");
			pw.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
			
			pw.println("<title>게시판 :: 목록</title>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<div class='container'>");
			
			pw.println("<h1>내용</h1>");
			pw.println("<table class='table table-bordered table-condensed'>");
			pw.println("<tr>");
			pw.println("<th>id</th><td>"+employee.getId()+"</td>");
			pw.println("<th>department id</th><td>"+employee.getDepartmentId()+"</td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<th>first name</th><td>"+employee.getFirstName()+"</td>");
			pw.println("<th>last name</th><td>"+employee.getLastName()+"</td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<th>email</th><td>"+employee.getEmail()+"</td>");
			pw.println("<th>phone number</th><td>"+employee.getPhoneNumber()+"</td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<th>salary</th><td>"+employee.getSalary()+"</td>");
			pw.println("<th>commission pct</th><td>"+employee.getCommissionPct()+"</td>");
			pw.println("</tr>");
			
			pw.println("</table>");
			
			pw.println("<div class='text-right'>");
			pw.println("<a href='delete.html?id="+employeeId+"&p="+p+"' class='btn btn-danger'>Delete</a>");
			pw.println("<a href='list.html?p="+p+"' class='btn btn-primary'>List</a>");
			pw.println("</div>");
			
			pw.println("</div>");
			pw.println("</body>");
			pw.println("</html>");
			
			
		} catch(SQLException e){
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
