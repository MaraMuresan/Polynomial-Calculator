package org.example.model;

import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Polynomial {

    private TreeMap<Integer, Double> monomials;

    public Polynomial() {
        monomials = new TreeMap<>();
    }

    // method to extract the degrees/coefficients of the monomial from the input string
    // the TreeMap: key = degree, value = coefficient

    public boolean isCorrectlyIntroduced(String inputString) {
        String regex = "([+-])\s(\\d+)?(x(\\^(\\d+))?)?";
        if(!inputString.matches(regex + "(\\s*" + regex + ")*")) return false;
        return true;
    }

    public void parsePolynomial(String inputString) {
        String regex = "([+-])\s(\\d+)?(x(\\^(\\d+))?)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputString);

        while (matcher.find()) {
            int sign;
            if(matcher.group(1).startsWith("-")) sign = -1;
            else sign = 1;

            double coefficient;
            if (matcher.group(2) == null) coefficient = sign;
            else coefficient = sign * Double.parseDouble(matcher.group(2));

            int degree;
            if (matcher.group(3) == null) degree = 0;
            else if (matcher.group(4) == null) degree = 1;
            else degree = Integer.parseInt(matcher.group(5));

            if(monomials.containsKey(degree)){
                coefficient = monomials.get(degree) + coefficient;
            }

            monomials.put(degree, coefficient);
        }
    }

    public void sortMonomialsDecreasingly() {
        TreeMap<Integer, Double> sortedMonomials = new TreeMap<>((a,b) -> b.compareTo(a));
        sortedMonomials.putAll(monomials);
        monomials = sortedMonomials;
    }

    public StringBuilder printPolynomial(TreeMap<Integer, Double> monomials ) {
        StringBuilder polynomialString = new StringBuilder();

        int zero = 0;

        for(int degree : monomials.keySet()) {
            double coefficient = monomials.get(degree);

            if (coefficient != 0) {
                zero = 1;
                if (coefficient > 0) polynomialString.append(" + ");
                else if (coefficient < 0) polynomialString.append(" - ");

                if (degree == 0 || Math.abs(coefficient) != 1)
                    polynomialString.append(String.format("%.2f", Math.abs(coefficient)));

                if(degree > 0) {
                    polynomialString.append("x");
                    if (degree > 1) polynomialString.append("^").append(degree);
                }
            }
        }

        if(zero == 0) polynomialString.append(" + 0.00");

        return polynomialString;
    }

    public TreeMap<Integer, Double> getMonomials() {
        return monomials;
    }

}
