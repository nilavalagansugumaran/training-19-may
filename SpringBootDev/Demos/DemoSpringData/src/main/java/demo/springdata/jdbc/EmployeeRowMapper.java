package demo.springdata.jdbc;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNumber) throws SQLException {
		return new Employee(rs.getInt("EmployeeID"),
				            rs.getString("Name"),
				            rs.getDouble("Salary"),
				            rs.getString("Region"));
	}
}
