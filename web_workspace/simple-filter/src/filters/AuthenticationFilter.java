package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter {

   private String[] urlItems;
   @Override
   public void init(FilterConfig filterConfig) throws ServletException {
      
      urlItems = filterConfig.getInitParameter("check-url").split(",");
   }
   
   @Override
   public void destroy() {
      
      
   }

   @Override
   public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
         throws IOException, ServletException {
      
      HttpServletRequest httpReq = (HttpServletRequest) req;
      String requestURI = httpReq.getRequestURI();
      String contextPath = httpReq.getContextPath();
      
      requestURI = requestURI.replace(contextPath, "");
      req.setAttribute("path", requestURI);
     
      if(isCheckedUrl(requestURI)) {
         HttpSession session = httpReq.getSession(false);
         if(session == null) {
            throw new ServletException("["+requestURI+"] 요청은 로그인이 필요한 서비스 입니다.");
         }
      }
      
      filterChain.doFilter(req, res);
   }

   private boolean isCheckedUrl(String url) {
      for(String item : urlItems) {
         if(item.equals(url)) {
            return true;
         } 
      }
      return false;
   }
}
   
