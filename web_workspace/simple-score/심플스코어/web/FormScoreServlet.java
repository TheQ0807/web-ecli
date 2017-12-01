package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form.html")
public class FormScoreServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		
		
		
		res.setContentType("text/html; charset=utf-8");
		PrintWriter pw = res.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html lang='ko'>");
		pw.println("<head>");
		pw.println("<meta charset='utf-8'>");
		pw.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
		pw.println("<title>성적 :: 입력 </title>");
		pw.println("</head>");
		
		pw.println("<div class='container'>");
		pw.println("<h1>성적입력</h1>");
		
		pw.println("<form method='post' action='addScore.html' class ='well'>");
		pw.println("<div class = 'form-group'>");
		pw.println("<label>이름</label>");
		pw.println("<input type='text' class='form-control' name='stname'/>");
		pw.println("<label>반</label>");
		pw.println("<input type='text' class='form-control' name='stban' />");				
		pw.println("</div>");
		
		pw.println("<div class='form-group'>");
		pw.println("<label>국어성적</label>");
		pw.println("<input type='text' class='form-control' name='stkor'/>");
		pw.println("<label>영어성적</label>");
		pw.println("<input type='text' class='form-control' name='steng'/>");
		pw.println("<label>수학성적</label>");
		pw.println("<input type='text' class='form-control' name='stmath'/>");
		pw.println("<label>과학성적</label>");
		pw.println("<input type='text' class='form-control' name='stsci'/>");
		pw.println("<label>역사성적</label>");
		pw.println("<input type='text' class='form-control' name='sthis'/>");
		pw.println("</div>");
	
		pw.println("<div class = 'form-group text-right'>");
		pw.println("<a href='' class='btn btn-default'>취소</a>");
		pw.println("<button type='submit' class='btn btn-primary'>저장</button>");
		pw.println("</div>");
		
		pw.println("</form>");
		
		pw.println("</div>");
		pw.println("</body>");
		pw.println("</html>");
	}

}
