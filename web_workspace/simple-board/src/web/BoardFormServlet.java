package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


@WebServlet("/form.html")
public class BoardFormServlet extends HttpServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		
		res.setContentType("text/html; charset=utf-8");
		PrintWriter pw = res.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html lang='ko'>");
		pw.println("<head>");
		pw.println("<meta charset='utf-8'>");
		pw.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
		pw.println("<title>게시판 :: 폼</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<div class='container'>");
		pw.println("<h1>새 글 입력폼</h1>");
	
		pw.println("<form method='post' action='add.html' class ='well'>");
		pw.println("<div class = 'form-group'>");
		pw.println("<label>제목</label>");
		pw.println("<input type='text' class='form-control' name='boardtitle'/>");
		pw.println("</div>");
		
		pw.println("<div class = 'form-group'>");
		pw.println("<label>작성자</label>");
		pw.println("<input type='text' class='form-control' name='boardwriter'/>");
		pw.println("</div>");
		
		pw.println("<div class = 'form-group'>");
		pw.println("<label>내용</label>");
		pw.println("<textarea class='form-control' name='boardcontents' rows='6'></textarea>");
		pw.println("</div>");
		
		pw.println("<div class = 'form-group text-right'>");
		pw.println("<a href='list.html' class='btn btn-default'>취소</a>");
		pw.println("<button type='submit' class='btn btn-primary'>저장</button>");
		pw.println("</div>");
		
		
		pw.println("</form>");
		
		pw.println("</div>");
		pw.println("</body>");
		pw.println("</html>");
		
	}
}
