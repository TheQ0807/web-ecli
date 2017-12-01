package dao;

import java.util.HashMap;
import java.util.Map;

import vo.User;

public class UserDao {

	private Map<String, User> db = new HashMap<>();
	public UserDao(){
		db.put("hong", new User("홍길동","hong","zxcv1234","USER"));
		db.put("kim", new User("김유신","kim","zxcv1234","ADMIN"));
	}
	
	public User getUserById(String id){
		return db.get(id);
	}
}
