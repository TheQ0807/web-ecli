package sample1;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class NumberTag extends SimpleTagSupport{

	private String number;
	private String pattern;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		int num = Integer.parseInt(number);
		DecimalFormat df = new DecimalFormat(pattern);
		String str = df.format(num);
		getJspContext().getOut().write(str);
	}
}
