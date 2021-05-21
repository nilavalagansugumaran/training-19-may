package com.example.demoEmployee.repository;

import com.example.demoEmployee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Employee getEmployee(long id){
        String sql = "select * from EMPLOYEES where id =?";
        return jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), id);
    }

    public List<Employee> getALL(){
        String sql = "select * from EMPLOYEES";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    @Transactional
    public Employee addEmployee(Employee employee){
       int id = jdbcTemplate.update("insert into EMPLOYEES (name, salary, dept) " +
                        "values (?, ?, ?)",
                new Object[]{employee.getName(), employee.getSalary(), employee.getDept()});

        String sql = "select * from EMPLOYEES where name =?";
        return jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), employee.getName());
    }

    @Transactional
    public void updateEmployee(Employee employee){
        String sql = "update EMPLOYEES set salary =? where id =?";
        jdbcTemplate.update(sql,
                new Object[]{employee.getSalary(), employee.getId()});
    }

    @Transactional
    public void deleteEmployee(long id){
        String sql = "delete from EMPLOYEES where id =?";
        jdbcTemplate.update(sql, id);
    }

    public static class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNumber) throws SQLException {
            return new Employee(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("dept"),
                    rs.getDouble("salary")
                    );
        }
    }

    @PostConstruct
    public void setup(){
        jdbcTemplate.execute("create table EMPLOYEES(" +
                "id int auto_increment, " +
                "name varchar(50), " +
                "salary double, " +
                "dept varchar(50), " +
                "primary key (id) )");

        jdbcTemplate.update("insert into EMPLOYEES (name, salary, dept) " +
                        "values (?, ?, ?)",
                new Object[]{"James", 21000, "London"});

    }


}
