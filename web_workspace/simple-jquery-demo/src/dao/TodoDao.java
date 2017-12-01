package dao;

import java.sql.SQLException;
import java.util.List;

import util.IbatisUtil;
import vo.Todo;

public class TodoDao {

	// Todo 저장
	public void createTodo(Todo todo) throws SQLException{
		IbatisUtil.getSqlMap().insert("createTodo", todo);
	}
	
	// todo_deleted가 'N'인 모든 Todo 조회
	public List<Todo> geTodos() throws SQLException{
		return  IbatisUtil.getSqlMap().queryForList("getTodo");
	}
	
	// 지정된 번호의 Todo 조회
	public Todo getTodoByNo(int no) throws SQLException{
		return (Todo) IbatisUtil.getSqlMap().queryForObject("getTodoByNo", no);
	}
	
	// 지정된 번호의 Todo의 todo_deleted를 'Y'로 바꾸기
	public void deleteTodo(int no) throws SQLException{
		IbatisUtil.getSqlMap().delete("deleteTodo",no);
	}
	
	// 지정된 번호의 Todo의 todo_completed를 '예'로 바꾸기
	public void completeTodo(int no)throws SQLException{
		IbatisUtil.getSqlMap().update("updateTodoCom",no);
	}
	
	public int getSequence() throws SQLException{
		return (Integer) IbatisUtil.getSqlMap().queryForObject("getSequence");
	}
	
	
}
