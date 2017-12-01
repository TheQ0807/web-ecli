package req.query;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/query-demo2.hta")
public class QueryStringDemoServlet2 extends HttpServlet {
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String sidoValue = req.getParameter("sido");
		String guValue = req.getParameter("gu");
		
		System.out.println("시도: " +sidoValue);
		System.out.println("구: "+ guValue);
	}
}
