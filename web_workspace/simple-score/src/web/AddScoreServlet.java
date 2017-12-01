package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ScoreDao;
import vo.Score;

@WebServlet("/addScore.html")
public class AddScoreServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		String name = req.getParameter("stname");
		int ban = Integer.parseInt(req.getParameter("stban"));
		int kor = Integer.parseInt(req.getParameter("stkor"));
		int eng = Integer.parseInt(req.getParameter("steng"));
		int math = Integer.parseInt(req.getParameter("stkor"));
		int sci = Integer.parseInt(req.getParameter("stkor"));
		int his = Integer.parseInt(req.getParameter("stkor"));
		
		Score score = new Score();
		score.setBan(ban);
		score.setKor(kor);
		score.setEng(eng);
		score.setMath(math);
		score.setName(name);
		score.setSci(sci);
		score.setHis(his);
		
		
		
		
		ScoreDao dao = ScoreDao.getDao();
		
		try{
			dao.addScore(score);
			
			res.sendRedirect("");
		} catch(SQLException e){
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		
	}
}
