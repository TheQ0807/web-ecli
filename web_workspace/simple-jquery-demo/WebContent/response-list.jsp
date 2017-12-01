<%@page import="com.google.gson.Gson"%>
<%@page import="vo.Todo"%>
<%@page import="java.util.List"%>
<%@page import="dao.TodoDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	TodoDao todoDao = new TodoDao();
	List<Todo> todos = todoDao.geTodos();

	Gson gson = new Gson();
	String jsontext = gson.toJson(todos);
	out.write(jsontext);
	

%>