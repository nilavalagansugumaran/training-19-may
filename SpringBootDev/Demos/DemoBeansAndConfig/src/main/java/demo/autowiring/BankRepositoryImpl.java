package demo.autowiring;

import org.springframework.stereotype.Repository;

@Repository
public class BankRepositoryImpl implements BankRepository {

	@Override
	public void doDeposit(int accountId, double amount) {
		String message = String.format("Depositing %.2f into account %d", amount, accountId);
		System.out.println("\tIn RepositoryImpl.doDeposit(), " + message);
	}

	@Override
	public void doWithdraw(int accountId, double amount) {
		String message = String.format("Withdrawing %.2f from account %d", amount, accountId);
		System.out.println("\tIn RepositoryImpl.doWithdraw(), " + message);
	}
}
