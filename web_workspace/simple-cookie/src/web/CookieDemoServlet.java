package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookies.html")
public class CookieDemoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		// 쿠키정보 가져오기
		Cookie[] cookies = req.getCookies();
		
		int visitCount = 0;
		
		if(cookies == null) {
			// 첫 방문일 경우 쿠키정보는 존잰하지 않는다.
			visitCount=1;
		} else{
			for(Cookie cookie : cookies){
				String name = cookie.getName();
				if("cnt".equals(name)){
					visitCount = Integer.parseInt(cookie.getValue()) + 1;
				}
			}
		}
		// 
		
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		
		pw.write("<html>");
		pw.write("<head><title>Cookie Sample</title></head>");
		pw.write("<body>");
		
		
		pw.write("<h1>쿠키연습</h1>");
		pw.write("<p>방문횟수:"+visitCount+" 회</p>");

		
		pw.write("</body>");
		pw.write("</html>");
		
		// 쿠키를 생성해서 응답으로 보내기
		// 쿠키 생성하기
		Cookie cookie = new Cookie("cnt", String.valueOf(visitCount));
		// 쿠키의 생존시간 설정하기
		cookie.setMaxAge(60);
		// 쿠키를 응답으로 보내기
		res.addCookie(cookie);
		
	}
}















