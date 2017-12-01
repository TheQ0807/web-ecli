package kr.co.jhta.board.dao;

import java.sql.SQLException;
import java.util.List;


import kr.co.jhta.board.vo.Board;
import kr.co.jhta.board.vo.Comment;
import kr.co.jhta.board.vo.Likes;
import kr.co.jhta.utils.IbatisUtil;

public class BoardDao {

	@SuppressWarnings("unchecked")
	public List<Board> getBoards() throws SQLException {
		return IbatisUtil.getSqlMap().queryForList("getBoards");
	}
	
	public void addBoard(Board board) throws SQLException{
		IbatisUtil.getSqlMap().insert("addBoard",board);
	}
	
	public void delBoard(int no) throws SQLException {
		IbatisUtil.getSqlMap().delete("delBoard",no);
	}
	
	public Board getBoardByNo(int no)throws SQLException {
		return (Board) IbatisUtil.getSqlMap().queryForObject("getBoardByNo", no);
	}
	
	public void addLikes(Likes likes)throws SQLException{
		IbatisUtil.getSqlMap().insert("addLikes",likes);
	}
	public int getLikes(Likes likes) throws SQLException{
		return (Integer) IbatisUtil.getSqlMap().queryForObject("getLikes",likes);
	}
	
	public void inactiveBoard(int no) throws SQLException{
		IbatisUtil.getSqlMap().update("inactiveBoard", no);
	}
	
	public void addComment(Comment comment)throws SQLException {
		IbatisUtil.getSqlMap().insert("addComment", comment);
	}
	
	@SuppressWarnings("unchecked")
	public List<Comment> getCommentsByBoardNo(int boardNo) throws SQLException {
		return IbatisUtil.getSqlMap().queryForList("getCommentsByBoardNo", boardNo);
	}
}
