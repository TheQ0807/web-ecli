<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Class.forName("oracle.jdbc.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","zxcv1234");
	PreparedStatement pstmt = con.prepareStatement("select* from departments order by department_id asc");
	ResultSet rs = pstmt.executeQuery();
	
	ArrayList<Dept> depts = new ArrayList<>();
	while(rs.next()){
		Dept dept = new Dept();
		dept.setId(rs.getInt("department_id"));
		dept.setName(rs.getString("department_name"));
		
		depts.add(dept);
	}
	
	rs.close();
	pstmt.close();
	con.close();
	
	Map<String, Object> map = new HashMap<>();
	map.put("resultCode","S");
	map.put("msg","성공");
	map.put("depts",depts);
	
	Gson gson = new Gson();
	String jsonText = gson.toJson(map);
	out.write(jsonText);
	
%>

<%!
	public class Dept {
		private int id;
		private String name;
		
		public int getId() {return id;}
		public void setId(int id){this.id = id;}
		public String getName(){return name;}
		public void setName(String name){this.name = name;}
		
	}
%>