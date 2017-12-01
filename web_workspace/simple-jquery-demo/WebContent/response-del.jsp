<%@page import="com.google.gson.Gson"%>
<%@page import="dao.TodoDao"%>
<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
 int no = Integer.parseInt(request.getParameter("no"));

TodoDao todoDao = new TodoDao();
todoDao.deleteTodo(no);

Gson gson = new Gson();
out.write(gson.toJson(no));

%>