import org.example.logic.Operation;
import org.example.logic.ResultDivision;
import org.example.model.Polynomial;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationTest {
    @Test
    public void additionTest() {
        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();
        Operation operation = new Operation();

        polynomial1.parsePolynomial("+ 3x + 2");
        polynomial2.parsePolynomial("+ 2x^2 - 7x + 2");

        Polynomial result = operation.addition(polynomial1, polynomial2);
        result.sortMonomialsDecreasingly();
        StringBuilder resultString = result.printPolynomial(result.getMonomials());

        assertEquals(" + 2.00x^2 - 4.00x + 4.00", resultString.toString());
    }

    @Test
    public void subtractionTest() {
        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();
        Operation operation = new Operation();

        polynomial1.parsePolynomial("+ 3x + 2");
        polynomial2.parsePolynomial("+ 2x^2 - 7x + 2");

        Polynomial result = operation.subtraction(polynomial1, polynomial2);
        result.sortMonomialsDecreasingly();
        StringBuilder resultString = result.printPolynomial(result.getMonomials());

        assertEquals(" - 2.00x^2 + 10.00x", resultString.toString());
    }

    @Test
    public void multiplicationTest() {
        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();
        Operation operation = new Operation();

        polynomial1.parsePolynomial("+ 3x + 2");
        polynomial2.parsePolynomial("+ 2x^2 - 7x + 2");

        Polynomial result = operation.multiplication(polynomial1, polynomial2);
        result.sortMonomialsDecreasingly();
        StringBuilder resultString = result.printPolynomial(result.getMonomials());

        assertEquals(" + 6.00x^3 - 17.00x^2 - 8.00x + 4.00", resultString.toString());
    }

    @Test
    public void divisionTest() {
        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();
        Operation operation = new Operation();

        polynomial1.parsePolynomial("+ x^3 - 2x^2 + 6x - 5");
        polynomial2.parsePolynomial("+ x^2 - 1");

        ResultDivision result = operation.division(polynomial1, polynomial2);
        Polynomial quotient = result.getQuotient();
        quotient.sortMonomialsDecreasingly();
        Polynomial reminder = result.getReminder();
        reminder.sortMonomialsDecreasingly();

        StringBuilder quotientString = quotient.printPolynomial(quotient.getMonomials());
        StringBuilder reminderString = reminder.printPolynomial(reminder.getMonomials());

        assertEquals(" + x - 2.00", quotientString.toString());
        assertEquals(" + 7.00x - 7.00", reminderString.toString());
    }

    @Test
    public void divisionTest2() {
        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();
        Operation operation = new Operation();

        polynomial1.parsePolynomial("+ 0");
        polynomial2.parsePolynomial("+ x^2 - 1");

        ResultDivision result = operation.division(polynomial1, polynomial2);
        Polynomial quotient = result.getQuotient();
        quotient.sortMonomialsDecreasingly();
        Polynomial reminder = result.getReminder();
        reminder.sortMonomialsDecreasingly();

        StringBuilder quotientString = quotient.printPolynomial(quotient.getMonomials());
        StringBuilder reminderString = reminder.printPolynomial(reminder.getMonomials());

        assertEquals(" + 0.00", quotientString.toString());
        assertEquals(" + 0.00", reminderString.toString());
    }

    @Test
    public void divisionTest3() {
        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();
        Operation operation = new Operation();

        polynomial1.parsePolynomial("+ x^3 - 2x^2 + 6x - 5");
        polynomial2.parsePolynomial("+ 0");

        ResultDivision result = operation.division(polynomial1, polynomial2);
        Polynomial quotient = result.getQuotient();
        quotient.sortMonomialsDecreasingly();
        Polynomial reminder = result.getReminder();
        reminder.sortMonomialsDecreasingly();

        StringBuilder quotientString = quotient.printPolynomial(quotient.getMonomials());
        StringBuilder reminderString = reminder.printPolynomial(reminder.getMonomials());

        assertEquals(" + 0.00", quotientString.toString());
        assertEquals(" + 0.00", reminderString.toString());
    }

    @Test
    public void divisionTest4() {
        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();
        Operation operation = new Operation();

        polynomial1.parsePolynomial("+ x^2 - 1");
        polynomial2.parsePolynomial("- x^2 + 1");

        ResultDivision result = operation.division(polynomial1, polynomial2);
        Polynomial quotient = result.getQuotient();
        quotient.sortMonomialsDecreasingly();
        Polynomial reminder = result.getReminder();
        reminder.sortMonomialsDecreasingly();

        StringBuilder quotientString = quotient.printPolynomial(quotient.getMonomials());
        StringBuilder reminderString = reminder.printPolynomial(reminder.getMonomials());

        assertEquals(" - 1.00", quotientString.toString());
        assertEquals(" + 0.00", reminderString.toString());
    }

    @Test
    public void derivativeTest() {
        Polynomial polynomial = new Polynomial();
        Operation operation = new Operation();

        polynomial.parsePolynomial("+ 3x^3 - 10x^2 - 7x + 2");

        Polynomial result = operation.derivative(polynomial);
        result.sortMonomialsDecreasingly();
        StringBuilder resultString = result.printPolynomial(result.getMonomials());

        assertEquals(" + 9.00x^2 - 20.00x - 7.00", resultString.toString());
    }

    @Test
    public void integrationTest() {
        Polynomial polynomial = new Polynomial();
        Operation operation = new Operation();

        polynomial.parsePolynomial("+ 3x^3 - 10x^2 - 7x + 2");

        Polynomial result = operation.integration(polynomial);
        result.sortMonomialsDecreasingly();
        StringBuilder resultString = result.printPolynomial(result.getMonomials());

        assertEquals(" + 0.75x^4 - 3.33x^3 - 3.50x^2 + 2.00x + C", resultString.toString() + " + C");
    }
}
