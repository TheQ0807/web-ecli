package filters;

import java.io.IOException;import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.User;

public class AuthorizationFilter implements Filter {

	private Map<String, List<String>> map = new HashMap<>();
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		map.put("/mail.html", Arrays.asList("USER","ADMIN"));
		map.put("/admin.html", Arrays.asList("ADMIN"));
		
	}
	
	@Override
	public void destroy() {
		
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		String path = (String) req.getAttribute("path");
		List<String> roles = map.get(path);
	
		
		if(roles != null) {
			HttpServletRequest httpReq = (HttpServletRequest) req;
			HttpSession session = httpReq.getSession(false);
			User user = (User) session.getAttribute("userInfo");
			
			if(!roles.contains(user.getRole())) {
				throw new ServletException("접근권한: "+roles+"보유권한: "+user.getRole());
			}
			
		}
		
		filterChain.doFilter(req, res);
	}


	
}
