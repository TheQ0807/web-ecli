package kr.co.jhta.board.dao;

import java.sql.SQLException;

import kr.co.jhta.board.vo.User;
import kr.co.jhta.utils.IbatisUtil;

public class UserDao {

	public void addUser (User user) throws SQLException {
		IbatisUtil.getSqlMap().insert("addUser", user);
	}
	
	public User getUserById(String userid)throws SQLException{
		return (User) IbatisUtil.getSqlMap().queryForObject("getUserById", userid);
	}
}
