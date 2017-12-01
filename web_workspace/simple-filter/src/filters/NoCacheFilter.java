package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class NoCacheFilter implements Filter {

	@Override
	public void destroy() {
		
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		
		filterChain.doFilter(req, res);
		
		HttpServletResponse httpRes = (HttpServletResponse) res;
		httpRes.setHeader("Cache-Control", "no-cache");
		httpRes.setHeader("Pragma", "no-cache");
		httpRes.setDateHeader("Expires", 0);
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}
	
}
