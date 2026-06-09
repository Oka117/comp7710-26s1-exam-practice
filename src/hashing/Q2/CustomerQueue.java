package hashing.Q2;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

class Customer {
    private String firstName;
    private String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        // TODO: Generate and return a hash code using both firstName and lastName.
        // Requirement: You must explicitly use the prime number 31 in your calculation.
        int hash = 0;
        for(int i = 0; i < firstName.length(); i++){
            hash = 31 * hash + firstName.charAt(i);
        }
        for(int i = 0; i < lastName.length(); i++){
            hash = 31 * hash + lastName.charAt(i);
        }
        return hash;
    }
}

class CustomerQueue {
    private List<Customer> queue;

    public CustomerQueue() {
        this.queue = new LinkedList<>();
    }

    public void add(Customer customer) {
        this.queue.add(customer);
    }

    @Override
    public int hashCode() {
        int result = 1;

        for (Customer c : queue) {
            // TODO: Update the 'result' variable to calculate the hash code for the entire queue.
            // Requirement 1: Process the customers from leftmost to rightmost.
            // Requirement 2: You must use the prime number 31 as the multiplier.
            // Requirement 3: A null customer should contribute 0 to the hash code.
            result = 31 * result + (c == null ? 0 : c.hashCode());
        }
        return result;
    }
}