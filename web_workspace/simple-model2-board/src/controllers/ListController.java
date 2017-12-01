package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import model2.Controller;
import vo.Board;

public class ListController implements Controller {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 게시글 조회
		BoardDao boardDao = BoardDao.getInstance();
		List<Board> boardList = boardDao.getAllBoards();

		// 뷰페이지에 전달하기 위해서 HttpServletRequest에 속성으로 저장하기
		request.setAttribute("boards", boardList);
		
		return "list.jsp";
	}
}
