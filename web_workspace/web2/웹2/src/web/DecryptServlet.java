package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.CipherUtils;

public class DecryptServlet extends HttpServlet {
	
	private String aesKey;
	
	@Override
	public void init() throws ServletException {
		aesKey = this.getServletContext().getInitParameter("aesKey");
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String encryptMessage = req.getParameter("message");
		
		String plainText = CipherUtils.decrypt(aesKey, encryptMessage);
		
		System.out.println("해석문: "+ plainText);
	}
	
}
