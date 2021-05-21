package demo.springdata.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmployeeRepository {

	@PersistenceContext(name="myPersistenceUnit")
	protected EntityManager entityManager;
    
	public long getEmployeeCount() throws DataAccessException {
		String jpql = "select count(e) from Employee e";
		TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
		return query.getSingleResult();
	}
    
	public Employee getEmployee(long employeeId) throws DataAccessException {
	    return entityManager.find(Employee.class, employeeId);
	}
    
	public List<Employee> getEmployees() throws DataAccessException {
		String jpql = "select e from Employee e";
		TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);
	    return query.getResultList();
	}
    
	@Transactional
	public void insertEmployee(Employee e) {
		entityManager.persist(e);
	}
	
	@Transactional
	public void updateEmployee(Employee e) {
		Employee entity = entityManager.find(Employee.class, e.getEmployeeId());
		entity.setName(e.getName());
		entity.setDosh(e.getDosh());
		entity.setRegion(e.getRegion());
	}
	
	@Transactional
	public void deleteEmployee(long employeeId) {
		Employee e = entityManager.find(Employee.class, employeeId);
		entityManager.remove(e);
	}
}
