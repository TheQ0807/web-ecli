package common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hta.controller.AboutController;
import com.hta.controller.HomeController;

@WebServlet("*.do")
public class FrontController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI().replace(request.getContextPath(),"");
		System.out.println("클라이언트 요청: "+ requestURI);
		
		String viewTemplate = null;
		Controller controller = null;
		if("/home.do".equals(requestURI)){
			viewTemplate = "WEB-INF/views/main.jsp";
			controller = new HomeController();
					
		} else if("/about.do".equals(requestURI)){
			viewTemplate = "WEB-INF/views/about.jsp";
			controller = new AboutController();
			
		} else{
			viewTemplate = "WEB-INF/views/404.jsp";
		}
		
		// 컨트롤러를 실행해서 클라이언트의 요청을 처리한다.
		if(controller != null){
			try {
				controller.process(request, response);
			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
		// 클라이언트의 요청처리가 완료되면 뷰템플릿페이지로 이동한다.
		request.getRequestDispatcher(viewTemplate).forward(request, response);
	}
}
