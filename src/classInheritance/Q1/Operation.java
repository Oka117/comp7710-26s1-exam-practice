package classInheritance.Q1;

/**
 * INSTRUCTIONS FOR STUDENTS:
 * 1. Create four concrete classes: 'Sum', 'Subtract', 'Multiply', and 'Divide'.
 * 2. All four classes must implement this Operation interface.
 * 3. Implement the execute() method for all four classes based on these strict business rules:
 * * RULE A (Sum, Subtract, Multiply):
 * - If BOTH parameters are of type 'Int', perform the math and return a new 'Int'.
 * - If EITHER parameter is of type 'Float', perform the math and return a new 'Float'.
 * * RULE B (Divide):
 * - ALWAYS perform the math and return a new 'Float', regardless of the input types.
 * - Ensure mathematical precision is preserved (e.g., Int 5 divided by Int 2
 * must return Float 2.5, not Float 2.0).
 * * HINT: Because 'Number' does not have a getValue() method, you will need to check the
 * runtime type of 'a' and 'b' and cast them to your concrete classes to retrieve their values.
 */
public interface Operation {
    Number execute(Number a, Number b);
}