package org.example.logic;

import org.example.model.Polynomial;
import java.util.TreeMap;

public class Operation {

    private void removeZeroCoefficientMonomials(TreeMap<Integer, Double> monomials) {
        monomials.entrySet().removeIf(entry -> entry.getValue() == 0);
    }

    private boolean isZero(Polynomial polynomial) {
        if(polynomial.getMonomials().size() == 1 && polynomial.getMonomials().containsKey(0) && polynomial.getMonomials().get(0) == 0) return true;
        return false;
    }

    public Polynomial addition(Polynomial polynomial1, Polynomial polynomial2) {

        Polynomial result = new Polynomial();
        result.getMonomials().putAll(polynomial1.getMonomials());

        for(int degree: polynomial2.getMonomials().keySet()) {
            double coefficient2 = polynomial2.getMonomials().get(degree);
            if(result.getMonomials().containsKey(degree)) {
                double coefficient1 = result.getMonomials().get(degree);
                result.getMonomials().put(degree, coefficient1 + coefficient2);
            }
            else result.getMonomials().put(degree, coefficient2);
        }
        removeZeroCoefficientMonomials(result.getMonomials());
        return result;
    }

    public Polynomial subtraction(Polynomial polynomial1, Polynomial polynomial2) {
        Polynomial result = new Polynomial();
        result.getMonomials().putAll(polynomial1.getMonomials());

        for(int degree: polynomial2.getMonomials().keySet()) {
            double coefficient2 = polynomial2.getMonomials().get(degree);
            if(result.getMonomials().containsKey(degree)) {
                double coefficient1 = result.getMonomials().get(degree);
                result.getMonomials().put(degree, coefficient1 - coefficient2);
            }
            else result.getMonomials().put(degree, (-1) * coefficient2);
        }
        removeZeroCoefficientMonomials(result.getMonomials());
        return result;
    }

    public Polynomial multiplication(Polynomial polynomial1, Polynomial polynomial2) {

        Polynomial result = new Polynomial();

        for(int degree1: polynomial1.getMonomials().keySet()) {
            double coefficient1 = polynomial1.getMonomials().get(degree1);
            for(int degree2: polynomial2.getMonomials().keySet()) {
                double coefficient2 = polynomial2.getMonomials().get(degree2);
                double coefficientProduct = coefficient1 * coefficient2;
                int degreeProduct = degree1 + degree2;
                if(result.getMonomials().containsKey(degreeProduct)) {
                    coefficientProduct += result.getMonomials().get(degreeProduct);
                }
                result.getMonomials().put(degreeProduct, coefficientProduct);
            }
        }
        return result;
    }

    public ResultDivision division(Polynomial polynomial1, Polynomial polynomial2) {
        Polynomial P, Q = new Polynomial();
        Polynomial quotient = new Polynomial();
        Polynomial reminder = new Polynomial();
        int max1, max2, aux;
        if(isZero(polynomial1) || isZero(polynomial2)) { quotient.getMonomials().put(0,0.00); reminder.getMonomials().put(0,0.00); }
        else {
            polynomial1.sortMonomialsDecreasingly();
            polynomial2.sortMonomialsDecreasingly();
            max1 = polynomial1.getMonomials().firstKey();
            max2 = polynomial2.getMonomials().firstKey();

            if (max1 >= max2) { P = polynomial1; Q = polynomial2; }
            else { P = polynomial2; Q = polynomial1; aux = max1; max1 = max2; max2 = aux;}

            while (max1 >= max2) {
                int degree = max1 - max2;
                double coefficient = P.getMonomials().get(max1) / Q.getMonomials().get(max2);
                quotient.getMonomials().put(degree, coefficient);
                Polynomial step = new Polynomial();
                step.getMonomials().put(degree, coefficient);
                P = subtraction(P, multiplication(Q, step));
                if(P.getMonomials().isEmpty())  P.getMonomials().put(0,0.00);
                P.sortMonomialsDecreasingly();
                max1 = P.getMonomials().firstKey();
            }
            reminder = P;
        }
        return new ResultDivision(quotient, reminder);
    }

    public Polynomial derivative(Polynomial polynomial) {
        Polynomial result = new Polynomial();

        for(int degree: polynomial.getMonomials().keySet()) {
            if(degree != 0) {
                double coefficient = polynomial.getMonomials().get(degree) * degree;
                result.getMonomials().put(degree - 1, coefficient);
            }
        }
        return result;
    }

    public Polynomial integration(Polynomial polynomial) {
        Polynomial result = new Polynomial();

        for(int degree: polynomial.getMonomials().keySet()) {
            double coefficient = polynomial.getMonomials().get(degree) / (degree + 1);
            result.getMonomials().put(degree + 1, coefficient);
        }
        return result;
    }

}
