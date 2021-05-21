package demo.testingessentials;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BankAccountTest2 {

    BankAccount fixture;

    @Before
    public void setup() {
        System.out.println("In setup()");
        fixture = new BankAccount("David");
    }

    @After
    public void teardown() {
        System.out.println("In teardown()");
    }

    @Test
    public void accountCreated_zeroBalanceInitially() {
        assertEquals(0, fixture.getBalance());
    }

    @Test
    public void deposit_singleDeposit_correctBalance() {

        // Act.
        fixture.deposit(100);

        // Assert.
        int expected = 100;
        int actual = fixture.getBalance();
        assertEquals(expected, actual);
    }

    @Test
    public void deposit_multipleDeposits_cumulativeBalance() {

        // Act.
        fixture.deposit(100);
        fixture.deposit(200);
        fixture.deposit(300);

        // Assert.
        int expected = 600;
        int actual = fixture.getBalance();
        assertEquals(expected, actual);
    }

    @Test
    public void deposit_withdrawalsWithinLimits_balanceReduced() {

        // Act.
        fixture.deposit(600);
        fixture.withdraw(100);
        fixture.withdraw(200);

        // Assert.
        int expected = 300;
        int actual = fixture.getBalance();
        assertEquals(expected, actual);
    }

    @Test
    public void deposit_withdrawalsUptoLimit_balanceZero() {

        // Act.
        fixture.deposit(600);
        fixture.withdraw(100);
        fixture.withdraw(200);
        fixture.withdraw(300);

        // Assert.
        int expected = 0;
        int actual = fixture.getBalance();
        assertEquals(expected, actual);
    }

    @Test
    public void deposit_withdrawalsExceedLimits_exceptionOccursV1() {

        // Act.
        fixture.deposit(600);

        try {
            fixture.withdraw(601);
            fail("Expected exception didn't occur!");
        }
        catch (IllegalArgumentException ex) {
            // Assert.
            assertEquals("Insufficient funds", ex.getMessage());
        }
    }

    @Test(expected=IllegalArgumentException.class)
    public void deposit_withdrawalsExceedLimits_exceptionOccursV2() {

        // Act.
        fixture.deposit(600);
        fixture.withdraw(601);
    }
}
