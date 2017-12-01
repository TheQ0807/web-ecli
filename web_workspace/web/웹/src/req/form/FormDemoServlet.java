package req.form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-demo.hta")
public class FormDemoServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		String name = req.getParameter("username");
		String phone = req.getParameter("userphone");
		String email = req.getParameter("useremail");
		
		System.out.println("이      름:"+ name);
		System.out.println("전화번호: "+ phone);
		System.out.println("이 메 일: "+ email);
	}
}
