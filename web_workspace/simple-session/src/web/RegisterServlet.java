package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import dao.UserDao;
import vo.User;

@WebServlet("/register.html")
public class RegisterServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		
		String name = req.getParameter("username");
		String email = req.getParameter("useremail");
		String id = req.getParameter("userid");
		String pwd = req.getParameter("userpwd");
		
		String sha256Pwd = DigestUtils.sha256Hex(pwd);
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setId(id);
		user.setPwd(sha256Pwd);
		
		UserDao dao = new UserDao();
		dao.addUser(user);
		
		res.sendRedirect("main.html");
		
	}
}
