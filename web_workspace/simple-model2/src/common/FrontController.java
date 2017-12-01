package common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Car;
import vo.UserVO;

@WebServlet(urlPatterns="*.hta")
public class FrontController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("클라이언트의 요청 접수...");
		
		// 클라이언트의 요청 분석
		String requestURI = request.getRequestURI();
		requestURI = requestURI.replace(request.getContextPath(), "");
		System.out.println("클라이언트의 요청: "+ requestURI);
		
		
		String viewTemplate = null;
		if("/main.hta".equals(requestURI)){
			// viewTemplate에 데이터 전달하기
			request.setAttribute("msg", "세미프로젝트 하느라 고생했습니다.");
			
			Car car = new Car(2017, "람보르기니");
			UserVO userInfo = new UserVO("홍길동","hong@gmail.com", car);
			request.setAttribute("user", userInfo);
			
			viewTemplate = "WEB-INF/views/main.jsp";
		} else if("/login.hta".equals(requestURI)){
			
			viewTemplate = "WEB-INF/views/login.jsp";
		} else if("/mypage.hta".equals(requestURI)){
			
			viewTemplate = "WEB-INF/views/mypage.jsp";
		} else{
			viewTemplate = "WEB-INF/views/404.jsp";
		}
		
		// 클라이언트의 요청을 viewTemplate으로 이동시키기
		RequestDispatcher rd = request.getRequestDispatcher(viewTemplate);
		rd.forward(request, response);
		
	}
}
