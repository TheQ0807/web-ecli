package dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import util.IbatisUtil;
import vo.Score;

public class ScoreDao {

	private static ScoreDao self = new ScoreDao();
	private ScoreDao(){}
	public static ScoreDao getDao() {
		return self;
	}
	
	private SqlMapClient smc = IbatisUtil.getSqlMap();
	
	public void addScore(Score score) throws SQLException {
		smc.insert("addScore", score);
	}
	
	public Score getScoreByNo(int no) throws SQLException {
		return (Score) smc.queryForObject("getScoreByNo", no);		
	}
	
}
