package demo2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/book.do")
public class BookJsonServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int bookNo = Integer.parseInt(req.getParameter("bno"));
		
		BookDao bookDao = new BookDao();
		Book book = bookDao.getBook(bookNo);
		
		res.setContentType("text/plain;charset=utf-8");
		PrintWriter pw = res.getWriter();
		
		Gson gson = new Gson();
		String text = gson.toJson(book);
		
		pw.write(text);
	}
}
