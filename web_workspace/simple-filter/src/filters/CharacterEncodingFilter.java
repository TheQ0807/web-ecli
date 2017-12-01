package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {

	private String defaultEncodingType;
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		defaultEncodingType = filterConfig.getInitParameter("encoding");
		
		if(defaultEncodingType == null) {
			defaultEncodingType = "UTF=8";
		}
		
	}

	@Override
	public void destroy() {
		
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		// 요청메세지의 인코딩 방식을 지정한다.
		req.setCharacterEncoding(defaultEncodingType);
		
		filterChain.doFilter(req, res);
		
	}
	
}
