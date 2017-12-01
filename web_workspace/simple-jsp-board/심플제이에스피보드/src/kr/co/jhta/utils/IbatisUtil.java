package kr.co.jhta.utils;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class IbatisUtil {

	private static SqlMapClient sqlMapClient;
	
	static {
		try{
		Reader reader = Resources.getResourceAsReader("kr/co/jhta/dao/ibatis/SqlMapConfig.xml");
		sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch(IOException e){
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public static SqlMapClient getSqlMap() {
		return sqlMapClient;
	}
}
