package classInheritance.Q1;

/**
 * INSTRUCTIONS FOR STUDENTS:
 * 1. Create two concrete classes named 'Int' and 'Float' that implement this interface.
 * 2. 'Int' must store a single integer value. 'Float' must store a single float value.
 * 3. Provide constructors to initialize these values, and getter methods to retrieve them.
 * 4. Implement the equalTo and comparedTo methods in both classes. (For the sake of this exam,
 * you may simply return 'false' and '0' for these two methods, as grading will focus on
 * the Operation implementations).
 */
public interface Number {
    boolean equalTo(Number n);
    int comparedTo(Number n);
}