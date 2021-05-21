package demo.configuration;

import java.util.Date;

public class BankServiceImpl implements BankService {

	private BankRepository repository;

	public BankServiceImpl(BankRepository repository) {
		System.out.println("*****New BankServiceImpl created at " + new Date());
		this.repository = repository;
	}

	@Override
	public void depositIntoAccount(int accountId, double amount) {
		System.out.printf("In BankServiceImpl.depositIntoAccount(%d, %.2f)\n", accountId, amount);
		repository.doDeposit(accountId, amount);
	}

	@Override
	public void withdrawFromAccount(int accountId, double amount) {
		System.out.printf("In BankServiceImpl.withdrawFromAccount(%d, %.2f)\n", accountId, amount);
		repository.doWithdraw(accountId, amount);
	}

	@Override
	public void transferFunds(int fromAccountId, int toAccountId, double amount) {
		System.out.printf("In BankServiceImpl.transferFunds(%d, %d, %.2f)\n", fromAccountId, toAccountId, amount);
		repository.doWithdraw(fromAccountId, amount);
		repository.doDeposit(toAccountId, amount);
	}
}
