package web;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import dao.FileDao;
import vo.FileInfo;

@WebServlet("/down.html")
public class FileDownloadServlet extends HttpServlet {

	private static final String SAVED_DIRECTORY = "c:\\web_eclipse\\attached-files\\";
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int no = Integer.parseInt(req.getParameter("fno"));
		
		FileDao fileDao = new FileDao();
		FileInfo fileInfo = fileDao.getFileInfo(no);
		
		String filename = fileInfo.getName();
		
		res.setContentType("application/octet-stream");
		res.setContentLengthLong(fileInfo.getSize());
		res.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(fileInfo.getShortName(), "utf-8"));
		
		ServletOutputStream os = res.getOutputStream();
		FileInputStream is = new FileInputStream(SAVED_DIRECTORY + filename);
		
		IOUtils.copy(is, os);
	}
}
