package model2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.AddController;
import controllers.DeleteController;
import controllers.DetailController;
import controllers.FormController;
import controllers.ListController;
import controllers.ModifyController;
import controllers.ModifyformController;

@WebServlet("*.do")
public class FrontController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String uri = request.getRequestURI();
			
			String path = null;
			Controller controller = null;
			if(uri.endsWith("list.do")){
				controller = new ListController();
				
			}	else if(uri.endsWith("form.do")){
				controller = new FormController();
				
			}	else if(uri.endsWith("add.do")){
				controller = new AddController();
				
			} 	else if(uri.endsWith("detail.do")){
				controller = new DetailController();
				
			}	else if(uri.endsWith("del.do")){
				controller = new DeleteController();
				
			}	else if(uri.endsWith("formmodify.do")){
				controller = new ModifyformController();
				
			}	else if(uri.endsWith("modify.do")){
				controller = new ModifyController();
				
			}	else{
				controller = new ListController();
				
			}
			
			// 컨트롤러 실행
			path = controller.process(request, response);
			// 페이지 이동시키기
	         if(path.startsWith("redirect")) {
	            // 브라우저가 새로운 페이지를 재요청하게 한다.
	            // 외부이동
	            path = path.replace("redirect:", "");
	            response.sendRedirect(path);
	         } else {
	            // 클라이언트의 요청을 지정된 경로의 jsp로 forwarding 시킨다.
	            // 요청객체, 응답객체가 뷰 페이지로 전달된다.
	            // 내부이동
	            request.getRequestDispatcher("WEB-INF/views/"+path).forward(request, response);
	         }
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
