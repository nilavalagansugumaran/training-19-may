	package demo.testingspringboot;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Lazy;
	import org.springframework.stereotype.Component;
	
	@Component
	@Lazy
	public class BAServiceBean {
	
	    private BARepository repos;
	
	    @Autowired
	    public BAServiceBean(BARepository repos) {
	        this.repos = repos;
	    }
	
	    public void depositIntoAccount(int id, int amount) {
	        BankAccountBean acc = repos.getById(id);
	        acc.deposit(amount);
	        repos.update(id, acc);
	    }
	}
