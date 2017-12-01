package dao;

import java.sql.SQLException;
import java.util.List;

import util.IbatisUtil;
import vo.Board;

public class BoardDao {

	private static BoardDao self = new BoardDao();
	private BoardDao(){}
	public static BoardDao getInstance() {
		return self;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Board> getAllBoards() throws SQLException {
		return IbatisUtil.getSqlMap().queryForList("getAllBoards");
	}
	
	public void addBoard(Board board) throws SQLException {
		IbatisUtil.getSqlMap().insert("addBoard", board);
	}
	
	public Board getBoardByNo(int no)throws SQLException {
		return (Board) IbatisUtil.getSqlMap().queryForObject("getBoardByNo", no);
	}
	
	public int getSeq() throws SQLException{
		return (int) IbatisUtil.getSqlMap().queryForObject("getSeq");
	}
}
