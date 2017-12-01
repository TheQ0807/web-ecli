package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detail.html")
public class DetailServlet extends HttpServlet {


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setAttribute("a", "아무거나 막 담아라" );
		req.setAttribute("b", "객체를 담아도 된다");
		req.setAttribute("c", "배열을 담아도 된다." );
		req.setAttribute("d", "콜렉션(리스트.셋)을 담아도 된다" );
		
	 	// RequestDispatcher는 지정된 url로 사용자의 요청을 이동시키는 객체다.
		RequestDispatcher dispatcher =  req.getRequestDispatcher("WEB-INF/detail.jsp");
		dispatcher.forward(req,res);
	}
}
