package web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.CipherUtils;

public class EncrytServlet extends HttpServlet {

	private String aesKey;
	
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		
		aesKey = application.getInitParameter("aesKey");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		String message = req.getParameter("message");
		
		String cipherText = CipherUtils.encrypt(aesKey, message);
		
		System.out.println("암호문: "+ cipherText);
	}
	
}
