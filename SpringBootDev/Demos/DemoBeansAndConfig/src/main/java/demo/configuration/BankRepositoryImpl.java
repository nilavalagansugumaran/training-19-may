package demo.configuration;

import java.util.Date;

public class BankRepositoryImpl implements BankRepository {

	public BankRepositoryImpl() {
		System.out.println("*****New BankRepositoryImpl created at " + new Date());
	}
	
	@Override
	public void doDeposit(int accountId, double amount) {
		String message = String.format("Depositing %.2f into account %d", amount, accountId);
		System.out.println("\tIn BankRepositoryImpl.doDeposit(), " + message);
	}

	@Override
	public void doWithdraw(int accountId, double amount) {
		String message = String.format("Withdrawing %.2f from account %d", amount, accountId);
		System.out.println("\tIn BankRepositoryImpl.doWithdraw(), " + message);
	}
}
