package first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String value1 = req.getMethod();
		String value2 = req.getRemoteAddr();
		String value3 = req.getHeader("host");
		String value4 = req.getHeader("user-agent");
		String value5 = req.getHeader("accept-language");
		String value6 = req.getHeader("accept-encoding");
		
//		System.out.println("요청방식: " + value1);
//		System.out.println("클라이언트 ip주소: " + value2);
//		System.out.println("호스트명: " + value3);
//		System.out.println("브라우저 정보: "+value4);
//		System.out.println("클라이언트가 지원하는 언어정보: " + value5);
//		System.out.println("클라이언트가 지원하는 인코딩방식: " + value6);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw =  resp.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html lang='ko'>");
		pw.println("<head><meta charset='utf-8'/><title>서블릿 연습</title></head>");
		pw.println("<body>");
		pw.println("<h1>클라이언트 정보</h1>");
		pw.println("<dl>");
		pw.println("<dt>ip주소</dt><dd>"+value2+"</dd>");
		pw.println("<dt>브라우저</dt><dd>"+ value4 +"</dd>");
		pw.println("<dt>지원언어</dt><dd>"+ value5 +"</dd>");
		pw.println("<dt>인코딩방식</dt><dd>"+value6 +"<dd>");
		pw.println("</dl>");
		pw.println("</body>");
		pw.println("</html>");
	}
}
