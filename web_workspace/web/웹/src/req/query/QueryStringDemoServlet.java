package req.query;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/query-demo.hta")
public class QueryStringDemoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String value = req.getParameter("cat");
		
		//System.out.println("선택한 카테고리: "+ value);
		resp.setContentType("text/plain;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		if("game".equals(value)) {
			pw.println("인기 게임 순위");
			pw.println("1. 배틀 그라운드");
			pw.println("2. 오버워치");
			pw.println("3. 리그 오브 레전드");
		} else if("movie".equals(value)){
			pw.println("인기 영화 순위");
			pw.println("1. 택시운전사");
			pw.println("2. 군함도");
			pw.println("3. 슈퍼배드 3");
		}else if("food".equals(value)) {
			pw.println("인기 음식 순위");
			pw.println("1. 고기(진리)");
			pw.println("2. 냉면");
			pw.println("3. 짜장");
		}else{
			pw.println("유효한 요청이 아닙니다.");
		}
				
	}
}
