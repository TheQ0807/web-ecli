package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import dao.UserDao;
import vo.User;

@WebServlet("/login.html")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String id = req.getParameter("userid");
		String pwd = req.getParameter("userpwd");
		
		//id와 일치하는 사용자정보를 db에서 조회한다.
		UserDao userDao = new UserDao();
		User user = userDao.getUserById(id);
		
		if(user == null) {
			throw new ServletException("아이디 혹은 비밀번호가 올바르지 않습니다.");
		}
		
		String sha256Pwd = DigestUtils.sha256Hex(pwd);
		
		if(!user.getPwd().equals(sha256Pwd)) {
			throw new ServletException("아이디 혹은 비밀번호가 올바르지 않습니다.");
		}
		
		// 아이디/비밀번호가 가입시 입력한 정보와 일치하는 경우
		HttpSession session = req.getSession(true);
		// HttpSession의 만료시간 설정하기
		session.setMaxInactiveInterval(60*5);
		
		System.out.println("세션아이디: "+ session.getId());
		// 세션객체에 사용자정보 저장
		session.setAttribute("userinfo", user);
		
		// 메인 화면으로 이동
		res.sendRedirect("main.html");
		
		
	}
}












