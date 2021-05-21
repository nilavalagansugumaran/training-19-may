package demo.springdata.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Lazy
public class EmployeeRepository {

	@Autowired
	JdbcTemplate template;
    
	public long getEmployeeCount() throws DataAccessException {
		String sql = "SELECT COUNT(*) FROM EMPLOYEES";
		return template.queryForObject(sql, Long.class);
	}
    
	public Employee getEmployee(long employeeId) throws DataAccessException {
		String sql = "SELECT * FROM EMPLOYEES WHERE EmployeeID=?";
		return template.queryForObject(sql, new EmployeeRowMapper(), employeeId);
	}
    
	public List<Employee> getEmployees() throws DataAccessException {
		String sql = "SELECT * FROM EMPLOYEES";
		return template.query(sql, new EmployeeRowMapper());
	}
    
	@Transactional
	public void insertEmployee(Employee e) {
		String sql = "INSERT INTO EMPLOYEES (Name, Salary, Region) VALUES (?, ?, ?)";
		template.update(sql, e.getName(), e.getDosh(), e.getRegion());
	}
	
	@Transactional
	public void updateEmployee(Employee e) {
		String sql = "UPDATE EMPLOYEES SET Name=?, Salary=?, Region=? WHERE EmployeeId=?";
		template.update(sql, e.getName(), e.getDosh(), e.getRegion(), e.getEmployeeId());
	}
	
	@Transactional
	public void deleteEmployee(long employeeId) {
		String sql = "DELETE FROM EMPLOYEES WHERE EmployeeID=?";
		template.update(sql, employeeId);
	}
}
