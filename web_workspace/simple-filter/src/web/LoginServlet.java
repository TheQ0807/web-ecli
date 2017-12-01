package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import vo.User;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		User user = new UserDao().getUserById(id);
		if(user == null) {
			throw new ServletException("아이디,비밀번호가 올바르지 않습니다.");
		}
		if(!user.getPwd().equals(pwd)) {
			throw new ServletException("아이디,비밀번호가 올바르지 않습니다.");
		}
		
		HttpSession session = req.getSession(true);
		session.setAttribute("userInfo", user);
		
		res.sendRedirect("index.html");
	}
}
