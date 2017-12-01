<%@page import="vo.Todo"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.List"%>
<%@page import="dao.TodoDao"%>
<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	Todo todo = new Todo();
	TodoDao todoDao = new TodoDao();
	todoDao.completeTodo(no);
	
	Gson gson = new Gson();
	out.write(gson.toJson(todoDao.getTodoByNo(no)));
	
%>