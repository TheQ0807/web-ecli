package common;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class FrontContraller extends HttpServlet {

	private Properties prop;
	
	@Override
	public void init() throws ServletException {
		prop = new Properties();
		try {
			prop.load(this.getClass().getResourceAsStream("mappings.properties"));
			System.out.println(prop);
		} catch (IOException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestURI = request.getRequestURI().replace(request.getContextPath(), "");
		System.out.println("클라이언트 요청: "+ requestURI);
		
		
		// controller 이름 알아내기
		String controllerClassName = prop.getProperty(requestURI);
		System.out.println("컨트롤러 클래스명: "+ controllerClassName);
		
		Controller controller = null;
		try {
			// controller객체 생성하기
			if(controllerClassName != null){
				controller =  (Controller) Class.forName(controllerClassName).newInstance();
			}
			
			// controller 실행
			String viewTemplate = null;
			if(controller != null){
				viewTemplate = controller.process(request, response);
			}
			
			// 클라이언트의 요청 이동시키기
			if(viewTemplate != null){
				if(viewTemplate.startsWith("redirect:")){
				   viewTemplate = viewTemplate.replace("redirect:", "");
				   response.sendRedirect(viewTemplate);
				} else {
					request.getRequestDispatcher("WEB-INF/views/"+ viewTemplate).forward(request, response);
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
