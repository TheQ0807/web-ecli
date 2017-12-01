<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String locId = request.getParameter("locId");
	
	String sql1 = "select departments_seq.nextval from dual";
	String sql2 = "insert into departments values(?,?,null, ?)";
	
	Class.forName("oracle.jdbc.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","zxcv1234");
	PreparedStatement pstmt = con.prepareStatement(sql1);
	ResultSet rs = pstmt.executeQuery();
	rs.next();
	int departmentId = rs.getInt(1);
	rs.close();
	pstmt.close();
	
	pstmt = con.prepareStatement(sql2);
	pstmt.setInt(1, departmentId);
	pstmt.setString(2, name);
	pstmt.setString(3, locId);
	pstmt.executeUpdate();
	
	pstmt.close();
	con.close();
	
	
	Map<String , Object> map = new HashMap<>();
	map.put("id", departmentId);
	map.put("name", name);
	map.put("gson", locId);
	
	Gson gson = new Gson();
	out.write(gson.toJson(map));
	
%>