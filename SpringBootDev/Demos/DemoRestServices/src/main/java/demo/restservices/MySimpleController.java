package demo.restservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MySimpleController {

	@RequestMapping(method=RequestMethod.GET, value="/employee1", headers="Accept=application/json, application/xml")
	public Employee getEmp1() {
		return new Employee("1", "John Smith", 100000);
	}

	@RequestMapping(method=RequestMethod.GET, value="/employee2", headers="Accept=application/json, application/xml")
	public Employee getEmp2() {
		return new Employee("2", "Jane Evans", 200000);
	}	
	
	@RequestMapping(method=RequestMethod.GET, value="/employeePv/{id}", headers="Accept=application/json, application/xml")
	public Employee getEmpViaPathVariable(@PathVariable String id) {
		return new Employee(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/employeeRp", headers="Accept=application/json, application/xml")
	public Employee getEmpViaRequestParam(@RequestParam(value="id", required=false, defaultValue="1234") String id) {
		return new Employee(id);
	}

	@ModelAttribute("offices")
	public List<Office> populateOffices() {
		List<Office> offices = new ArrayList<Office>();
		offices.add(new Office("England", "London"));
		offices.add(new Office("France",  "Paris"));
		offices.add(new Office("USA",     "New York"));
		offices.add(new Office("Norway",  "Tromso"));
		offices.add(new Office("Wales",   "Swansea :-)"));
		return offices;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/office", headers="Accept=application/json, application/xml")
	@SuppressWarnings("unchecked")
	public Office getOffice(@RequestParam(value="index", required=false, defaultValue="0") int index, ModelMap model) {
	
		List<Office> offices = (List<Office>)model.get("offices");
		if (index < 0 || index >= offices.size())
			index = 0;
	
		return offices.get(index);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/offices", headers="Accept=application/json, application/xml")
	@SuppressWarnings("unchecked")
	public List<Office> getAllOffices(ModelMap model) {
		return (List<Office>)model.get("offices");
	}
}
