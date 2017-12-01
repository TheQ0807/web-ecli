package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import util.StringUtils;
import vo.Criteria;
import vo.Employee;

@WebServlet({"/list.html", "/index.html"})
public class ListServlet extends HttpServlet {
		
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// 한 화면에 표시할 데이터 행의 갯수
		final int rowsPerPage = 5;
		// 한 화면에 표시할 페이지 내비게이션 갯수
		final int naviPerPage = 5;
		
		// 현재 페이지번호를 계산
		int p = StringUtils.strToNumber(req.getParameter("p"), 1);
		
		
		try {
			EmployeeDao dao= new EmployeeDao();
			
			///////////// 페이지 네비게이션 구성하기 /////////////
			// 전체 데이터 갯수 
			int totalRows = dao.getTotalRows();
			// 전체 페이지 갯수 계산
			int totalPages = (int) Math.ceil(totalRows/(double)rowsPerPage);
			// 전체 페이지 네비게이션 블록 갯수 계산
			int totalNaviBlocks = (int) Math.ceil(totalPages/(double) naviPerPage);
			// 현재 페이지 네비게이션 블록 번호 계산
			int currentNaviBlock = (int) Math.ceil(p/(double) naviPerPage);
			// 페이지 네비게이션으로 표시할 시작 페이지 번호와 끝 페이지번호 계산
			int beginPage = (currentNaviBlock -1)*naviPerPage +1 ;
			int endPage = currentNaviBlock*naviPerPage;
			if (currentNaviBlock == totalNaviBlocks){
				endPage = totalPages;
			}
			
			/////////// 현재 페이지번호에 해당하는 데이터 조회하기 ///////
			// 현재 페이지번호에 해당하는 데이터 조회시의 시작인덱스 계산
			int beginIndex = (p-1)* rowsPerPage +1;
			// 현재 페이지번호에 해당하는 데이터 조회시의 끝인덱스 계산
			int endIndex = p*rowsPerPage;

			Criteria criteria = new Criteria();
			criteria.setBeginIndex(beginIndex);
			criteria.setEndIndex(endIndex);
			
			// 페이지 번호에 해당하는 게시글 조회
			List<Employee> employees = dao.getEmployees(criteria);
			
			
			
			
			res.setContentType("text/html; charset=utf-8");
			PrintWriter pw = res.getWriter();
			pw.println("<!DOCTYPE html>");
			pw.println("<html lang='ko'>");
			pw.println("<head>");
			pw.println("<meta charset='utf-8'>");
			pw.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
			
			pw.println("<title>게시판 :: 목록</title>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<div class='container'>");
			pw.println("<h1>목록</h1>");
			pw.println("<table class = 'table table-condensed'>");
			pw.println("<tr>");
			pw.println("<th>id</th><th>first name</th><th>last name</th><th>작성일</th>");
			pw.println("</tr>");
			pw.println("</thead>");
			pw.println("<tbody>");
			
			for (Employee employee : employees) {
	            pw.println("      <tr>");
	            pw.println("         <td>"+employee.getId()+"</td>");
	            pw.println("         <td><a href='detail.html?id="+employee.getId()+"#'>"+employee.getFirstName()+"</a></td>");
	            pw.println("         <td><a href='detail.html?id="+employee.getId()+"#'>"+employee.getLastName()+"</a></td>");
	            pw.println("         <td>"+employee.getJobId()+"</td>");
	            pw.println("      </tr>");
	         }
			
			 pw.println("      </tbody>");
	         pw.println("   </table>");
	         
	         pw.println("<div class='text-center'>");
	         pw.println("<ul class='pagination'>");
	         // 이전 블록으로 이동하기
	         if(currentNaviBlock>1){
	        	 pw.println("<li><a href='list.html?p="+((currentNaviBlock-1)*naviPerPage)+"'>&laquo;</a></li>");
	         }else
	        	 pw.println("<li class='disabled'><a href='list.html?p="+p+"'>&laquo;</a></li>");
	         // 이전페이지로 이동
	         if(p>1){
	        	 pw.println("<li><a href='list.html?p="+(p-1)+"'>&lt;</a></li>");
	         }else {
	        	 pw.println("<li class='disabled'><a href='#'>&lt;</a></li>");
	         }
	         for(int index = beginPage; index<=endPage; index++) {
	        	 pw.println("<li class='"+(p==index?"active":"")+"'><a href='list.html?p="+index+"'>"+index+"</a></li>");
	         }
	         
//	         for(int index=1; index<=totalPages; index++) {
//	        	 if(p == index) {
//	        		 pw.println("<li class='active'><a href='list.html?p="+index+"'>"+index+"</a></li>");	 
//	        	 }else {
//	        	 	 pw.println("<li><a href='list.html?p="+index+"'>"+index+"</a></li>");
//	        	 }
//	         }
	         // 다음 페이지로 이동
	         if(totalPages>p) {
	        	 pw.println("<li><a href='list.html?p="+(p+1)+"'>&gt;</a></li>");
	         }else{
	        	 pw.println("<li class='disabled'><a href='#'>&gt;</a></li>");
	         }
	         // 다음 블록으로 이동
	         
	         if(totalNaviBlocks>currentNaviBlock){
	        	 pw.println("<li><a href='list.html?p="+(currentNaviBlock*naviPerPage+1)+"'>&raquo;</a></li>");
	         }else{
	        	 pw.println("<li class='disabled'><a href='list.html?p="+p+"'>&raquo;</a></li>");
	         }
	         pw.println("</ul>");
	         pw.println("</div>");
	         pw.println("</div>");
	         pw.println("</body>");
	         pw.println("</html>");
			
			
		}catch (SQLException e){
			e.printStackTrace();
			throw new ServletException();
		}
	}
}
