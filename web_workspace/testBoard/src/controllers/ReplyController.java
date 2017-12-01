package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import model2.Controller;
import vo.Board;

public class ReplyController implements Controller{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String contents = request.getParameter("contents");
		int pno = Integer.parseInt(request.getParameter("pno"));
		int no = BoardDao.getInstance().getSeq();
		
		Board board = new Board();
		board.setNo(no);
		board.setTitle(title);
		board.setWriter(writer);
		board.setContents(contents);
		board.setPno(pno);
		BoardDao.getInstance().addBoard(board);
		return "redirect:list.do";
	}
}
