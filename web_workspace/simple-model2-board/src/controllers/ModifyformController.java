package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import model2.Controller;
import vo.Board;

public class ModifyformController implements Controller {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int no = Integer.parseInt(request.getParameter("no"));
		Board board = BoardDao.getInstance().getBoardByNo(no);
		
		request.setAttribute("board", board);
		
		return "modifyform.jsp";
	}
}
