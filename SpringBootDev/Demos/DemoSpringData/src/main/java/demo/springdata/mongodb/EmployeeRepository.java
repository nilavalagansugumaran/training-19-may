package demo.springdata.mongodb;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface EmployeeRepository extends MongoRepository<Employee,Long> {
    
	List<Employee> findEmployeesByRegion(String region);
    
	@Query("{'dosh' : {$gte : ?0, $lte : ?1}}")
    List<Employee> findEmployeesInSalaryRange(double from, double to);
    
	Page<Employee> findEmployeesByDoshGreaterThan(double salary, Pageable pageable);
}
