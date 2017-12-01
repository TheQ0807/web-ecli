package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import util.StringUtils;

@WebServlet("/delete.html")
public class DeleteServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int employeeId = StringUtils.strToNumber(req.getParameter("id"));
		int p = StringUtils.strToNumber(req.getParameter("p"), 1);
		
		try{
			EmployeeDao dao = new EmployeeDao();
			dao.deleteEmployeeById(employeeId);
			
			res.sendRedirect("list.html?p="+ p);
		} catch(SQLException e){
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
