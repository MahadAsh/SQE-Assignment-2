Summary:
The Calculator.divide method throws IllegalArgumentException with message "division by zero" for divisor=0. This failure is discovered by an automated JUnit parameterized test and is logged as a bug.

Steps to Reproduce:

Open the project in Eclipse / terminal.

Run the JUnit test: CalculatorTest.divide_byZero_throwsIllegalArgumentException()
OR run all tests: mvn -DincludeTags=fast test

Observe the failing test and exception in the JUnit console.

Test Case Reference:

Test ID: TC02 (TestCases.xlsx)

Test Case Description: Verify division by zero

Test Input: input1=5, input2=0, operation=DIV

Expected Output: Exception (ArithmeticException or handled failure)

Actual Output: IllegalArgumentException thrown with message "division by zero"

Actual Result:
An IllegalArgumentException is thrown by Calculator.divide when divisor=0. The exception type and message are not standard or descriptive.

Expected Result:
Division by zero should either:

Throw a standard ArithmeticException with message "Division by zero is not allowed", OR

Be handled gracefully (e.g., method returns Optional.empty() or custom checked exception explained in API)

Impact:

Unit tests expecting a specific exception type may fail.

API consumers expecting ArithmeticException will get unexpected exception type.

Low severity functional defect but important for correctness and consistency.

Suggested Fix:

Change Calculator.divide to throw ArithmeticException for division-by-zero:
if (b == 0) throw new ArithmeticException("Division by zero is not allowed");

Update unit tests to assert the desired exception type/message.

Logs / Output:
(Attach the JUnit output or console log if available.)

Environment:

OS: [your OS]

Java: 11

Build tool: Maven

IDE: Eclipse

Project: unit-test-project v1.0-SNAPSHOT

Attachments:

docs/jira_failure_screenshot.png (screenshot of failing JUnit test in Eclipse)

docs/TestCases.xlsx (reference test cases)

src/test/resources/addition_test_cases.csv (used for parameterized tests)