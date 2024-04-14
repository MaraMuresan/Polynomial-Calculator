package org.example.controller;

import org.example.logic.ResultDivision;
import org.example.model.Polynomial;
import org.example.logic.Operation;
import org.example.view.CalculatorView;

public class CalculatorController {

    private Operation operation;

    private CalculatorView view;

    public CalculatorController(CalculatorView view) {
        this.operation = new Operation();
        this.view = view;
    }

    public String addition(String p1, String p2) {
        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();

        if(polynomial1.isCorrectlyIntroduced(p1) && polynomial2.isCorrectlyIntroduced(p2)) {
            polynomial1.parsePolynomial(p1);
            polynomial2.parsePolynomial(p2);

            Polynomial result = operation.addition(polynomial1, polynomial2);
            result.sortMonomialsDecreasingly();
            StringBuilder resultString = result.printPolynomial(result.getMonomials());
            return resultString.toString();
        }
        else return "Error!   Input example: + 3x^2 - 7x + 5";
    }

    public String subtraction(String p1, String p2) {
        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();

        if(polynomial1.isCorrectlyIntroduced(p1) && polynomial2.isCorrectlyIntroduced(p2)) {
            polynomial1.parsePolynomial(p1);
            polynomial2.parsePolynomial(p2);

            Polynomial result = operation.subtraction(polynomial1, polynomial2);
            result.sortMonomialsDecreasingly();
            StringBuilder resultString = result.printPolynomial(result.getMonomials());
            return resultString.toString();
        }
        else return "Error!   Input example: + 3x^2 - 7x + 5";
    }

    public String multiplication(String p1, String p2) {
        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();

        if(polynomial1.isCorrectlyIntroduced(p1) && polynomial2.isCorrectlyIntroduced(p2)) {
            polynomial1.parsePolynomial(p1);
            polynomial2.parsePolynomial(p2);

            Polynomial result = operation.multiplication(polynomial1, polynomial2);
            result.sortMonomialsDecreasingly();
            StringBuilder resultString = result.printPolynomial(result.getMonomials());
            return resultString.toString();
        }
        else return "Error!   Input example: + 3x^2 - 7x + 5";
    }

    public String[] division(String p1, String p2) {
        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();

        if(polynomial1.isCorrectlyIntroduced(p1) && polynomial2.isCorrectlyIntroduced(p2)) {
            polynomial1.parsePolynomial(p1);
            polynomial2.parsePolynomial(p2);

            ResultDivision result = operation.division(polynomial1, polynomial2);
            Polynomial quotient = result.getQuotient();
            quotient.sortMonomialsDecreasingly();
            Polynomial reminder = result.getReminder();
            reminder.sortMonomialsDecreasingly();

            StringBuilder quotientString = quotient.printPolynomial(quotient.getMonomials());
            StringBuilder reminderString = reminder.printPolynomial(reminder.getMonomials());
            return new String[] {quotientString.toString(), reminderString.toString()};
        }
        else return new String[] {"Error!   Input example: + 3x^2 - 7x + 5" , "Error!   Input example: + 3x^2 - 7x + 5"};
    }

    public String derivative(String p) {
        Polynomial polynomial = new Polynomial();

        if(polynomial.isCorrectlyIntroduced(p)) {
            polynomial.parsePolynomial(p);

            Polynomial result = operation.derivative(polynomial);
            result.sortMonomialsDecreasingly();
            StringBuilder resultString = result.printPolynomial(result.getMonomials());
            return resultString.toString();
        }
        else return "Error!   Input example: + 3x^2 - 7x + 5";
    }

    public String integration(String p) {
        Polynomial polynomial = new Polynomial();

        if(polynomial.isCorrectlyIntroduced(p)) {
            polynomial.parsePolynomial(p);

            Polynomial result = operation.integration(polynomial);
            result.sortMonomialsDecreasingly();
            StringBuilder resultString = result.printPolynomial(result.getMonomials());
            return resultString.toString() + " + C";
        }
        else return "Error!   Input example: + 3x^2 - 7x + 5";
    }
}
