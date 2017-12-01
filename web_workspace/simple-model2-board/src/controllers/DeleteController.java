package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import model2.Controller;

public class DeleteController implements Controller {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try{
			int no = Integer.parseInt(request.getParameter("no"));
			BoardDao.getInstance().deleteBoardByNo(no);
			
		} catch (NumberFormatException e) {
			return "redirect:list.do";
		}
		
		return "redirect:list.do";
	}
}
