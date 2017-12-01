package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.WebUtils;

@WebServlet("/detail.html")
public class PorductDetailServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String productName = req.getParameter("name");
		
		String value = WebUtils.getCookieValue(req.getCookies(), "recent");
		
		if(value != null) {
			if(!value.contains(productName)) {
				value +=":"+ productName;
			}
		} else {
			value = productName;
		}
		
		Cookie cookie = new Cookie("recent", value);
		cookie.setMaxAge(60*60*365);
		res.addCookie(cookie);
		
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		
		pw.println("<!DOCTYPE html>");
		pw.println("<html lang='ko'>");
		pw.println("<head>");
		pw.println("<meta charset='utf-8'>");
		pw.println("<title>정보</title>");
		pw.println("</head>");
		pw.println("<body>");
		
		pw.println("<h1>정보</h1>");
		pw.println("<p>"+productName +"의 상세정보를 표시합니다.</p>");
		pw.println("<p><a href='list.html'>리스트</a></p>");
		
		pw.println("</body>");
		pw.println("</html>");
		
	}
}
