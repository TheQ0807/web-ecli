package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import vo.Board;

@WebServlet("/detail.html")
public class BoardDetailServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		// 상세정보를 조회할 글번호 얻기
		int no = Integer.parseInt(req.getParameter("no"));
		
		try{
			BoardDao dao = BoardDao.getInstance();
			Board board = dao.getBoardByNo(no);
			
			res.setContentType("text/html; charset=utf-8");
			PrintWriter pw = res.getWriter();
			pw.println("<!DOCTYPE html>");
			pw.println("<html lang='ko'>");
			pw.println("<head>");
			pw.println("<meta charset='utf-8'>");
			pw.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
			
			pw.println("<title>게시판 :: 글정보</title>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<div class='container'>");

			pw.println("<h1>글 정보</h1>");
			pw.println("<table class='table table-condensed table-bordered'>");
			pw.println("<colgroup>");
			pw.println("<col width ='20%'>");
			pw.println("<col width ='*'>");
			pw.println("</colgroup>");
			
			pw.println("<tr>");
			pw.println("<th>번호</th><td>"+board.getNo()+"</td>");
			pw.println("<tr>");
			pw.println("<tr>");
			pw.println("<th>제목</th><td>"+board.getTitle()+"</td>");
			pw.println("<tr>");
			pw.println("<tr>");
			pw.println("<th>작성자</th><td>"+board.getWriter()+"</td>");
			pw.println("<tr>");
			pw.println("<tr>");
			pw.println("<th>등록일</th><td>"+board.getSimpleCreatedate()+"</td>");
			pw.println("<tr>");
			pw.println("<tr>");
			pw.println("<th>내용</th><td>"+board.getContents()+"</td>");
			pw.println("<tr>");
			pw.println("</table>");
			
			
			pw.println("<div class='text-right'>");
			pw.println("<a href='delete.html?no="+no+"' class='btn btn-danger'>삭제</a>");
			pw.println("<a href='list.html' class='btn btn-primary'>목록</a>");
			pw.println("</div>");
			
			pw.println("</div>");
			pw.println("</body>");
			pw.println("</html>");
			
			
		} catch(SQLException e){
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}
}
