package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.WebUtils;

@WebServlet("/list.html")
public class ProductListServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		
		pw.println("<!DOCTYPE html>");
		pw.println("<html lang='ko'>");
		pw.println("<head>");
		pw.println("<meta charset='utf-8'>");
		pw.println("<title>리스트</title>");
		pw.println("</head>");
		pw.println("<body>");
		
		pw.println("<h1>상품리스트</h1>");
		pw.println("<ul>");
		
		pw.println("<li><a href='detail.html?name=macbookpro'>맥북 프로</a></li>");
		pw.println("<li><a href='detail.html?name=macbookair'>맥북 에어</a></li>");
		pw.println("<li><a href='detail.html?name=iphone'>아이폰 8s</a></li>");
		pw.println("<li><a href='detail.html?name=padpro'>아이패드 프로</a></li>");
		pw.println("<li><a href='detail.html?name=galexy'>겔럭시 노트8</a></li>");
		pw.println("<li><a href='detail.html?name=watch'>애플워치</a></li>");
		pw.println("</ul>");
		
		String value = WebUtils.getCookieValue(req.getCookies(), "recent");
		
		pw.println("<h2>최근 본 상품</h2>");
		if (value != null) {
			String[] items = value.split(":");
			pw.println("<ul>");
			for(String name: items) {
				pw.println("<li>"+name+"</li>");
			}
			pw.println("</ul>");
		} else {
			pw.println("<p>없음</p>");
		}
		
		
		pw.println("</body>");
		pw.println("</html>");
		
		
		
		
	}
}
