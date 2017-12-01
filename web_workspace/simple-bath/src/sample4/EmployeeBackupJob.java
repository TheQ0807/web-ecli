package sample4;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class EmployeeBackupJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		try {
			PrintWriter out = new PrintWriter("c:/temp/emp.csv");
			out.println("id,firstname,lastname,job,salary");
			
			
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","zxcv1234");
			PreparedStatement pstmt = con.prepareStatement("select* from employees order by employee_id");
			ResultSet rs = pstmt.executeQuery();
		
			while(rs.next()){
				int id = rs.getInt("employee_id");
				String firstname = rs.getString("first_name");
				String lastname = rs.getString("last_name");
				String job = rs.getString("job_id");
				double salary = rs.getDouble("salary");
				
				out.println(id+","+firstname+","+lastname+","+job+","+salary);
			}
			rs.close();
			pstmt.close();
			con.close();
			
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
