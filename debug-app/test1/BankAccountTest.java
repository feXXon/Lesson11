import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BankAccountTest {
    @Test
    public void shouldNotBeBlockedWhenCreated() {
        BankAccount account = new BankAccount("a", "b");
        assertFalse(account.isBlocked());
    }

    @Test
    public void shouldBeBlockedAfterBlockIsCalled() {
        BankAccount account = new BankAccount("Alice", "Smith");
        account.block();
        assertTrue(account.isBlocked());
    }

    @Test
    public void shouldReturnFirstNameThenSecondName() {
        BankAccount account = new BankAccount("John", "Doe");
        String[] fullName = account.getFullName();
        assertEquals("John", fullName[0]);
        assertEquals("Doe", fullName[1]);
    }

    @Test
    public void shouldReturnNullAmountWhenNotActive() {
        BankAccount account = new BankAccount("Jane", "Doe");
        assertThrows(IllegalStateException.class, () -> account.getAmount());
        assertNull(account.getCurrency());
    }

    @Test
    public void shouldReturnCorrectAmountAfterActivation() {
        BankAccount account = new BankAccount("Peter", "Jones");
        account.activate("USD");
        assertEquals(Integer.valueOf(0), account.getAmount());
        assertEquals("USD", account.getCurrency());
    }
}
