<%@page import="org.apache.tomcat.util.http.fileupload.IOUtils"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<% 
	String b = request.getParameter("b");
	String e = request.getParameter("e");
	
	String path = "http://openapi.seoul.go.kr:8088/746847426465756e333176516c6d49/xml/SearchConcertDetailService/"+b+"/"+e+"/";
	

	URL url = new URL(path);
	InputStream in = url.openStream();
	
	IOUtils.copy(in, response.getOutputStream());

%>