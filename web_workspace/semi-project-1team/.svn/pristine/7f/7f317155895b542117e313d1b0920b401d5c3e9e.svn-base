<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	request.setCharacterEncoding("utf-8");
	Part part = request.getPart("f");
	String contentDisposition = part.getHeader("content-disposition");
	String fileName = null;
	String[] items = contentDisposition.split(";");
	for(String item : items) {
		
		if(item.trim().startsWith("filename")) {
			fileName = item.substring(item.indexOf("=")+2, item.length()-1);
		}
	}
	Thread.sleep(3000);
	part.write("C:\\web_eclipse\\web_workspace\\SmartEditor-Test\\WebContent\\img\\"+fileName);
	System.out.println(fileName);
	out.write(fileName);
%>