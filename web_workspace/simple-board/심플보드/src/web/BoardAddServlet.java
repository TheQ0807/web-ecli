package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import vo.Board;

@WebServlet("/add.html")
public class BoardAddServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		req.setCharacterEncoding("utf-8");
		String title = req.getParameter("boardtitle");
		String writer = req.getParameter("boardwriter");
		String contents = req.getParameter("boardcontents");
		
		Board board = new Board();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContents(contents);
		
		BoardDao dao = BoardDao.getInstance();
		
		
		try{
			dao.addBoard(board);
			
			res.sendRedirect("list.html");
		} catch(SQLException e){
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}

	
}