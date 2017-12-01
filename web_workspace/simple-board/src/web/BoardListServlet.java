package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import dao.BoardDao;
import util.StringUtils;
import vo.Board;
import vo.Criteria;


@WebServlet(urlPatterns={"/index.html","/list.html"})
public class BoardListServlet extends HttpServlet {
	
	
	//로그 객체 생성
	private static Logger logger = Logger.getLogger(BoardListServlet.class);
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		logger.debug("게시글 목록 조회 시작");
		long startTime = 0;
		 if(logger.isDebugEnabled()) {
	         startTime = System.currentTimeMillis();
	     }

		//검색어를 입력하고 검색 버튼을 눌렀을때만  값이 존재한다.
		String opt = req.getParameter("opt");
		String keyword = req.getParameter("keyword");
		logger.info("검색옵션 ["+opt+"] 키워드["+keyword+"]");
		
		Criteria criteria = new Criteria();
		criteria.setOpt(opt);
		criteria.setKeyword(keyword);
		
		
		
		BoardDao dao = BoardDao.getInstance();
		try {
			List<Board> boardList = dao.getAllBoards(criteria);
			logger.info("조회 건수["+boardList.size()+"]");
			logger.debug("조회된 개시글["+boardList+"]");
			
			
			res.setContentType("text/html; charset=utf-8");
			PrintWriter pw = res.getWriter();
			pw.println("<!DOCTYPE html>");
			pw.println("<html lang='ko'>");
			pw.println("<head>");
			pw.println("<meta charset='utf-8'>");
			pw.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
			
			pw.println("<title>게시판 :: 목록</title>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<div class='container'>");
			pw.println("<h1>목록</h1>");
			pw.println("<table class = 'table table-condensed'>");
			pw.println("<tr>");
			pw.println("<th>번호</th><th>제목</th><th>조회수</th><th>작성일</th>");
			pw.println("</tr>");
			pw.println("</thead>");
			pw.println("<tbody>");
			
			for(Board board: boardList) {
			
				int no = board.getNo();
				String title = board.getTitle();
				int hit = board.getHit();
				String createdate = board.getSimpleCreatedate();
				
				pw.println("<tr>");
				pw.println("<td>"+no+"</td><td><a href='hit.html?no="+no+"'>"+title+"</a></td><td>"+hit+"</td><td>"+createdate+"</td>");
				pw.println("<tr>");
			
			}
			
			pw.println("</tbody>");
			pw.println("</table>");
			pw.println("<hr/>");
			pw.println("<div class='text-right'>");
			pw.println("<a href='form.html' class='btn btn-primary'>새글</a>");
			pw.println("</div>");
		
			pw.println("<div class='text-center'>");
			pw.println("<form class='form-inline' action='list.html' method='get'>");
			
			pw.println("<div class='form-group'>");
			pw.println("<label class='sr-only'>옵션</label>");
			pw.println("<select class='form-control' name='opt'>");
			pw.println("<option value='title'"+ ("title".equals(opt) ? "selected":"") +">제목</option>");
			pw.println("<option value='writer'"+ ("writer".equals(opt) ? "selected":"") +">작성자</option>");
			pw.println("<option value='contents'"+ ("contents".equals(opt) ? "selected":"") +">내용</option>");
			pw.println("</select>");
			pw.println("</div>");
			
			pw.println("<div class='form-group'>");
			pw.println("<label class='sr-only'>검색어</label>");
			pw.println("<input type='text' class='form-control' name='keyword' value='"+ StringUtils.nullToBlank(keyword)+"'/>");
			pw.println("</div>");
			pw.println("<button type='submit' class='btn btn-default'>검색</button>");
			pw.println("</form>");
			pw.println("</div>");
			
			pw.println("</div>");
			pw.println("</body>");
			pw.println("</html>");
			
			if(logger.isDebugEnabled()) {
				long endTime = System.currentTimeMillis();
				logger.debug("수행시간["+(endTime-startTime)+"] 밀리초]");
			}	
		
		} catch (SQLException e) {
			logger.error("게시글 조회 중 에러발생", e);
			throw new ServletException(e);
		}
	
	}
}
