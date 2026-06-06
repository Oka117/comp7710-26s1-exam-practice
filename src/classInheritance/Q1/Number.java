package classInheritance.Q1;

/**
 * INSTRUCTIONS FOR STUDENTS:
 * 1. Create two concrete classes named 'Int' and 'Float' that implement this interface.
 * 2. 'Int' must store a single integer value as it is. 'Float' must store a single float/double value as a float.
 * 3. Provide constructors to initialize these values, and getter methods to retrieve them.
 * 4. Implement the equalTo and comparedTo methods in both classes according to the following rules:
 *
 *    equalTo(Number n):
 *    - Return true if both objects represent the same numeric value.
 *    - Return false otherwise.
 *    - Comparisons must work across types. For example:
 *          new Int(5).equalTo(new Float(5.0f)) == true
 *          new Float(3.5f).equalTo(new Int(3)) == false
 *
 *    comparedTo(Number n):
 *    - Return a negative value if this object's numeric value is less than n.
 *    - Return 0 if both objects represent the same numeric value.
 *    - Return a positive value if this object's numeric value is greater than n.
 *    - Comparisons must work across types. For example:
 *          new Int(3).comparedTo(new Float(4.5f)) < 0
 *          new Float(5.0f).comparedTo(new Int(5)) == 0
 *          new Float(7.5f).comparedTo(new Int(2)) > 0
 */
public interface Number {
    boolean equalTo(Number n);
    int comparedTo(Number n);
}