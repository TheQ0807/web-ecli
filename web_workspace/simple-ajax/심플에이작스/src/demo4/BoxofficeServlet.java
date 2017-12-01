package demo4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

@WebServlet("/boxoffice.do")
public class BoxofficeServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String date = req.getParameter("date");
		String path = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?key=726512c39b94fec57ffea53d92b955ff&targetDt="+date;
		
		URL url = new URL(path);
		InputStream in = url.openStream();
		
		res.setContentType("text/xml;charset=urf-8");
		OutputStream out = res.getOutputStream();
		
		IOUtils.copy(in, out);
	}
}
