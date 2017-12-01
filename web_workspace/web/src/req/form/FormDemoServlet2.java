package req.form;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form.demo2.hta")
public class FormDemoServlet2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		req.setCharacterEncoding("utf-8");
		
		String phone = req.getParameter("phone");
		String jumin = req.getParameter("jumin");
		String username = req.getParameter("username");
		String userpw	= req.getParameter("userpwd");
		String location = req.getParameter("location");
		String gender = req.getParameter("gener");
		String[] tech = req.getParameterValues("tech");
		
		
		System.out.println(phone);
		System.out.println(jumin);
		System.out.println(username);
		System.out.println(userpw);
		System.out.println(location);
		System.out.println(gender);
		System.out.println(Arrays.toString(tech));
		
		/*
		 * User user =new User();
		 * user.setPhone(phone);
		 * user.setJumin(jumin);
		 * user.setUsername(username);
		 * ...
		 * user.setTech(tech);
		 */
	}
}
 