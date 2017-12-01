package demo.hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

	public Employee getEmployeeById(int id) throws Exception{
		Employee emp = null;
		String sql= "select* from employees where employee_id=?";
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","zxcv1234");
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			emp = new Employee();
			emp.setId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			emp.setEmail(rs.getString("email"));
			emp.setPhoneNumber(rs.getString("phone_number"));
			emp.setHireDate(rs.getDate("hire_date"));
			emp.setJobId(rs.getString("job_id"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setCommissionPct(rs.getDouble("commission_pct"));
			emp.setManagerId(rs.getInt("manager_id"));
			emp.setDepartmentId(rs.getInt("department_id"));
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return emp;
	}
	
	
	public List<Employee> getAllEmployees() throws Exception {
		
		List<Employee> employees = new ArrayList<>();
		String sql="select* from employees order by employee_id";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","zxcv1234");
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Employee emp = new Employee();
			emp.setId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			//emp.setEmail(rs.getString("email"));
			//emp.setPhoneNumber(rs.getString("phone_number"));
			//emp.setHireDate(rs.getDate("hire_date"));
			emp.setJobId(rs.getString("job_id"));
			//emp.setSalary(rs.getDouble("salary"));
			//emp.setCommissionPct(rs.getDouble("commission_pct"));
			//emp.setManagerId(rs.getInt("manager_id"));
			//emp.setDepartmentId(rs.getInt("department_id"));
			
			employees.add(emp);
		}
		rs.close();
		pstmt.close();
		con.close();
				
		return employees;
	}
	
	
}
