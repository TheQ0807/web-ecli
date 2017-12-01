package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FileDao;
import vo.FileInfo;

@WebServlet("/list.html")
public class FileListServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		
		pw.println("<!DOCTYPE html>");
		pw.println("<html lang='ko'>");
		pw.println("<head>");
		pw.println("<meta charset='utf-8'>");
		pw.println("<title>파일리스트</title>");
		pw.println("</head>");
		pw.println("<body>");
		
		pw.println("<h1>파일리스트</h1>");
		pw.println("<table style='width:100%;' border='1'>");
		pw.println("<tr>");
		pw.println("<th>파일명</th>");
		pw.println("<th>사이즈</th>");
		pw.println("<th>설명</th>");
		pw.println("</tr>");
		FileDao fileDao = new FileDao();
		List<FileInfo> list = fileDao.getFileInfoList();
		
		for(FileInfo fileInfo : list){
			pw.println("<tr>");
			pw.println("<td><a href='down.html?fno="+fileInfo.getNo()+"'>"+fileInfo.getShortName()+"</a></td>");
			pw.println("<td>"+fileInfo.getSizeWithComma()+"</td>");
			pw.println("<td>"+fileInfo.getSummary()+"</td>");
			pw.println("</tr>");
		}
		pw.println("</table>");
		pw.println("<a href='form.html'>자료 재업로드</a>");
		
		pw.println("</body>");
		pw.println("</html>");
	}
	
}
