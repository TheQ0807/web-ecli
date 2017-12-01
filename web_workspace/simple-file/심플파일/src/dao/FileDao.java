package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.FileInfo;

public class FileDao {

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","zxcv1234");
	}
	
	public FileInfo getFileInfo(int no) {
		String sql = "select* from tb_attached_file where file_no = ?";
		FileInfo fileInfo = null;
		
		try{
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				fileInfo = new FileInfo();
				fileInfo.setNo(rs.getInt("file_no"));
				fileInfo.setName(rs.getString("file_name"));
				fileInfo.setSize(rs.getLong("file_size"));
				fileInfo.setSummary(rs.getString("file_summary"));
				fileInfo.setCreatedate(rs.getDate("file_createdate"));
				
			}
			rs.close();
			pstmt.close();
			con.close();
			
			return fileInfo;
			
		} catch(ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<FileInfo> getFileInfoList() {
		String sql = "select* from tb_attached_file order by file_no desc";
		List<FileInfo> list = new ArrayList<>();
		
		try{
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				FileInfo fileInfo = new FileInfo();
				fileInfo.setNo(rs.getInt("file_no"));
				fileInfo.setName(rs.getString("file_name"));
				fileInfo.setSize(rs.getLong("file_size"));
				fileInfo.setSummary(rs.getString("file_summary"));
				fileInfo.setCreatedate(rs.getDate("file_createdate"));
				
				list.add(fileInfo);
			}
			rs.close();
			pstmt.close();
			con.close();
			
			return list;
			
		} catch(ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
	
		
	}
	
	
	public void addFileInfo(FileInfo fileInfo) {
		String sql = "insert into tb_attached_file values(board_seq.nextval, ?,?,sysdate, ?)";
		
		try{
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, fileInfo.getName());
			pstmt.setLong(2, fileInfo.getSize());
			pstmt.setString(3, fileInfo.getSummary());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
		} catch(ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
