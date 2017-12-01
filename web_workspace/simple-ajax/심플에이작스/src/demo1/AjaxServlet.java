package demo1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/data.do")
public class AjaxServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/plain;charset=utf-8");
		PrintWriter pw = res.getWriter();
		
		pw.println("김유신,이순신,강감찬,홍길동,유관순,안중근");
		
	}
}
