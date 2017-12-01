<%@page import="com.google.gson.Gson"%>
<%@page import="vo.Todo"%>
<%@page import="dao.TodoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String title = request.getParameter("title");
	String dates = request.getParameter("dates");
	String contents = request.getParameter("contents");


	TodoDao todoDao = new TodoDao();
	int no = todoDao.getSequence();
	
	Todo todo = new Todo();
	todo.setNo(no);
	todo.setTitle(title);
	todo.setDates(dates);
	todo.setContents(contents);
	
	todoDao.createTodo(todo);
	
	Todo newTodo = todoDao.getTodoByNo(no);
	
	Gson gson = new Gson();
	out.write(gson.toJson(newTodo));
%>