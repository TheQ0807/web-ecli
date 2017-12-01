package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginform.html")
public class LoginFormServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		
		pw.println("<!doctype html>");
		pw.println("<html lang='ko'>");
		pw.println("<head>");
		pw.println("<meta charset='utf-8'>");
		pw.println("</head>");
		
		pw.println("<body>");
		pw.println("<h1>로그인 폼</h1>");
		
		pw.println("<form method='post' action='login.html'>");
		pw.println("ID:<br/>");
		pw.println("<input type='text' name='userid'/><br/>");
		pw.println("PWD:<br/>");
		pw.println("<input type='password' name='userpwd'><br/>");
		pw.println("<button type='submit'>로그인</button>");
		pw.println("</form>");
		
		pw.println("</body>");
		pw.println("</html>");
	}
}
