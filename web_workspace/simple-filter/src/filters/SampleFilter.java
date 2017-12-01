package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SampleFilter implements Filter {

	private String value1;
	private String value2;
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		value1 = filterConfig.getInitParameter("aaa");
		value2 = filterConfig.getInitParameter("ccc");
		
	}
	
	
	@Override
	public void destroy() {
		
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		
		System.out.println("SampleFilter의 전처리 코드가 실행됨.");
		System.out.println("첫번째값: "+ value1);
		System.out.println("두번째값: "+ value2);
		filterChain.doFilter(req, res);
		
		System.out.println("SampleFilter의 후처리 코드가 실행됨.");
		
	}


}
