package sample1;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport {
	
	private String message;
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void doTag() throws JspException, IOException {
		
		JspContext jspContext =  getJspContext();
		JspWriter out = jspContext.getOut();
		out.println("<p>"+message+"</p>");
	}
}
