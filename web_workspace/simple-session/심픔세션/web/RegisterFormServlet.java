package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registerform.html")
public class RegisterFormServlet extends  HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		
		pw.println("<!doctype html>");
		pw.println("<html lang='ko'>");
		pw.println("<head>");
		pw.println("<meta charset='utf-8'>");
		pw.println("<title>회원가입 폼</title>");
		pw.println("</head>");
		
		pw.println("<body>");
		pw.println("<h1>회원가입 폼</h1>");
		
		pw.println("<form method='post' action='register.html'>");
		pw.println("이름:<br/>");
		pw.println("<input type='text' name='username'/><br/>");
		pw.println("이메일:<br/>");
		pw.println("<input type='text' name='useremail'/><br/>");
		pw.println("아이디:<br/>");
		pw.println("<input type='text' name='userid'/><br/>");
		pw.println("비밀번호:<br/>");
		pw.println("<input type='password' name='userpwd'><br/>");
		pw.println("<button type='submit'>회원가입</button>");
		pw.println("</form>");
		
		pw.println("</body>");
		pw.println("</html>");
	}
}
