package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;

@WebServlet("/delete.html")
public class BoardDeleteServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// 쿼리스트링으로 전달받은 글번호 가져오기
		int no = Integer.parseInt(req.getParameter("no"));
		
		try{
			// 글 삭제
			BoardDao dao = BoardDao.getInstance();
			dao.deleteBoardByNo(no);
			
			// 브라우저가 list.html을 재요청하도록 url을 보낸다.
			res.sendRedirect("list.html");
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
	
}
