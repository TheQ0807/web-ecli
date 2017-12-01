package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.User;

@WebServlet("/main.html")
public class MainServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		
		pw.println("<!doctype html>");
		pw.println("<html lang='ko'>");
		pw.println("<head>");
		pw.println("<meta charset='utf-8'>");
		pw.println("</head>");
		pw.println("<title>메인 페이지</title>");
		pw.println("<body>");
		pw.println("<h1>메인 페이지</h1>");
		
		boolean isLogined = false;
		User user =null;
		
		HttpSession session =  req.getSession(false);
		if(session !=null) {
			user = (User) session.getAttribute("userinfo");
			if(user !=null) {
				isLogined = true;
			}
		}
		if(isLogined) {
			pw.println("<p>"+user.getName()+"님 환영합니다.</p>");
			pw.println("<p><a href='logout.html'>로그아웃</a></p>");
			pw.println("<p><a href='mail.html'>내 메일</a></p>");
		}else{
			pw.println("<p><a href='registerform.html'>회원가입</a></p>");
			pw.println("<p><a href='loginform.html'>로그인폼</a></p>");
		}
		
		pw.println("</body>");
		pw.println("</html>");
	}
}













