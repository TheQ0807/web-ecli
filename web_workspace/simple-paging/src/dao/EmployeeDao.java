package dao;

import java.sql.SQLException;
import java.util.List;


import com.ibatis.sqlmap.client.SqlMapClient;

import util.IbatisUtil;
import vo.Criteria;
import vo.Employee;

public class EmployeeDao {

   private SqlMapClient smc = IbatisUtil.getSqlMap();
   
   public int getTotalRows() throws SQLException {
      return (Integer)smc.queryForObject("getTotalRows");
   }
   
   public List<Employee> getEmployees(Criteria criteria) throws SQLException {
      return smc.queryForList("getEmployees", criteria);
   }
   
   public Employee getEmployeeById(int employeeId) throws SQLException {
	   return (Employee) IbatisUtil.getSqlMap().queryForObject("getEmployeeById", employeeId);
   }
   
   public void deleteEmployeeById(int employeeId) throws SQLException {
	   IbatisUtil.getSqlMap().delete("deleteEmployeeById", employeeId);
   }
}