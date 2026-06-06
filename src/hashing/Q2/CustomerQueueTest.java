package hashing.Q2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerQueueTest {
    @Test
    public void testEmptyQueueHash() {
        CustomerQueue q = new CustomerQueue();

        assertEquals(1, q.hashCode());
    }

    @Test
    public void testSameQueueHash() {
        CustomerQueue q1 = new CustomerQueue();
        CustomerQueue q2 = new CustomerQueue();

        q1.add(new Customer("John", "Smith"));
        q1.add(new Customer("Bob", "Brown"));

        q2.add(new Customer("John", "Smith"));
        q2.add(new Customer("Bob", "Brown"));

        assertEquals(q1.hashCode(), q2.hashCode());
    }
    @Test
    public void testSameUsersDifferentOrderHash() {
        CustomerQueue q1 = new CustomerQueue();
        CustomerQueue q2 = new CustomerQueue();

        q1.add(new Customer("John", "Smith"));
        q1.add(new Customer("Bob", "Brown"));

        q2.add(new Customer("Bob", "Brown"));
        q2.add(new Customer("John", "Smith"));

        assertNotEquals(q1.hashCode(), q2.hashCode());
    }
}

class CustomerTest{

    @Test
    public void testCustomerHashEqualObjects() {
        Customer c1 = new Customer("John", "Smith");
        Customer c2 = new Customer("John", "Smith");

        assertEquals(c1.hashCode(), c2.hashCode());
    }
    @Test
    public void testCustomerHashDifferentFirstName() {
        Customer c1 = new Customer("John", "Smith");
        Customer c2 = new Customer("Bob", "Smith");

        assertNotEquals(c1.hashCode(), c2.hashCode());
    }
    @Test
    public void testCustomerHashDifferentLastName() {
        Customer c1 = new Customer("John", "Smith");
        Customer c2 = new Customer("John", "Brown");

        assertNotEquals(c1.hashCode(), c2.hashCode());
    }

    @Test
    public void testCustomerFirstLastNameSwapped() {
        Customer c1 = new Customer("John", "Smith");
        Customer c2 = new Customer("Smith", "John");

        assertNotEquals(c1.hashCode(), c2.hashCode());
    }
    @Test
    public void testCustomerHashConsistent() {
        Customer c = new Customer("John", "Smith");

        int h1 = c.hashCode();
        int h2 = c.hashCode();
        int h3 = c.hashCode();

        assertEquals(h1, h2);
        assertEquals(h2, h3);
    }
}
