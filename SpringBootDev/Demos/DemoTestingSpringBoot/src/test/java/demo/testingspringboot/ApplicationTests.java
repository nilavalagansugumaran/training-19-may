package demo.testingspringboot;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    BankAccountBean fixture;

    @Test
	public void contextLoads() {
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
}
