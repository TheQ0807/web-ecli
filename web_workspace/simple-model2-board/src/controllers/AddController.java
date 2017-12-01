package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import model2.Controller;
import vo.Board;

public class AddController implements Controller{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
			if(!request.getParameter("title").equals(null) && !request.getParameter("writer").equals(null) && !request.getParameter("contents").equals(null)){
				if(!request.getParameter("title").equals(" ") && !request.getParameter("writer").equals(" ") && !request.getParameter("contents").equals(" ")){
					String title = request.getParameter("title");
					String writer = request.getParameter("writer");
					String contents = request.getParameter("contents");
					
					Board board = new Board();
					board.setTitle(title);
					board.setWriter(writer);
					board.setContents(contents);
					BoardDao.getInstance().addBoard(board);
				}
			}
			return "redirect:list.do";
		
	}
}
