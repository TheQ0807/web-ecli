package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ScoreDao;
import util.StringUtils;
import vo.Score;

@WebServlet("/detail.html")
public class DetailScoreServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int scoreNo = StringUtils.strToNumber(req.getParameter("no"));
		
		int p = StringUtils.strToNumber(req.getParameter("p"), 1);
		
		try{
			ScoreDao dao = ScoreDao.getDao();
			Score score = dao.getScoreByNo(scoreNo);
			
			res.setContentType("text/html; charset=utf-8");
			PrintWriter pw = res.getWriter();
			pw.println("<!DOCTYPE html>");
			pw.println("<html lang='ko'>");
			pw.println("<head>");
			pw.println("<meta charset='utf-8'>");
			pw.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
			
			pw.println("<title>게시판 :: 학생세부사항</title>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<div class='container'>");
			
			pw.println("<h1>학생</h1>");
			pw.println("<table class='table table-bordered table-condensed'>");
			pw.println("<tr>");
			pw.println("<th>학번</th><td>"+score.getNo()+"</td>");
			pw.println("<th>이름</th><td>"+score.getName()+"</td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<th>반</th><td>"+score.getBan()+"</td>");
			pw.println("<th>등록일</th><td>"+score.getSysdate()+"</td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<th>국어</th><td>"+score.getKor()+"</td>");
			pw.println("<th>영어</th><td>"+score.getEng()+"</td>");
			pw.println("<th>수학</th><td>"+score.getMath()+"</td>");
			pw.println("<th>과학</th><td>"+score.getSci()+"</td>");
			pw.println("<th>역사</th><td>"+score.getHis()+"</td>");
			pw.println("<th>성적총합</th><td>"+(score.getKor()+score.getEng()+score.getMath()+score.getSci()+score.getHis())+"</td>");
			pw.println("<th>평균</th><td>"+((double)(score.getKor()+score.getEng()+score.getMath()+score.getSci()+score.getHis())/5)+"</td>");
			pw.println("</tr>");
			
			pw.println("</table>");
				
			pw.println("</div>");
			pw.println("</body>");
			pw.println("</html>");
			
			
		} catch(SQLException e){
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}

