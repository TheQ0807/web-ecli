package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import model2.Controller;
import vo.Board;

public class ListController implements Controller{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Board> boardList = BoardDao.getInstance().getAllBoards();
		
		
		request.setAttribute("boardList", boardList);
		
		return "list.jsp";
	}
}
