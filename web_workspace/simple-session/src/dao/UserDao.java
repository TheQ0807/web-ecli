package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.User;

public class UserDao {

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","zxcv1234");
	}
	
	public User getUserById(String userId) {
		String sql = "select* from tb_user where user_id = ?";
		User user = null;
		try{
			Connection con = this.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,userId);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				user = new User();
				user.setId(rs.getString("user_id"));
				user.setName(rs.getString("user_name"));
				user.setPwd(rs.getString("user_pwd"));
				user.setEmail(rs.getString("user_email"));
			}
			rs.close();
			pstmt.close();
			con.close();
			
			return user;
		}  catch(ClassNotFoundException|SQLException e) {
			
			throw new RuntimeException(e);
			
		}
	}
	
	public void addUser(User user){
		String sql = "insert into tb_user values(?,?,?,?)";
		
		try{
			Connection con = this.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPwd());
			pstmt.setString(4, user.getEmail());
			
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
			
		} catch(ClassNotFoundException|SQLException e) {
			
			throw new RuntimeException(e);
			
		}
		
	}
	
}
