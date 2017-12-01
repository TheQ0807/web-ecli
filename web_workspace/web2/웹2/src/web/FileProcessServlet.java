package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileProcessServlet extends HttpServlet{

	private String directory;
	private long fileSize;
	
	@Override
	public void init() throws ServletException {
		ServletConfig config = this.getServletConfig();
		
		directory = config.getInitParameter("directoryPath");
		fileSize = Long.parseLong(config.getInitParameter("maxFileSize"));
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			System.out.println("파일 디렉토리: "+ directory);
			System.out.println("최대 파일크기: "+ fileSize);
	}
	
}
