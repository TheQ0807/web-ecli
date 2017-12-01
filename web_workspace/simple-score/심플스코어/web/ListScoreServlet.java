package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.StringUtils;

@WebServlet("")
public class ListScoreServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		final int rowsPerPage = 5;
		final int naviPerPage = 5;
		
		int p = StringUtils.strToNumber(req.getParameter("p"), 1);
		
		
		
		
	}
}
