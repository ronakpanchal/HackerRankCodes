package com.practice.solutions;

public class HornerMethod {


    public static void main(String[] args) {
        String input = "name";
        HornerMethod obj = new HornerMethod();
        double result = obj.evaluateNonRecursivey(input, 10);
        System.out.println("The polynomial value for given string is " + result);
    }

    public double evaluatePolynomial(String polynomial, int pos, int base) {
        if (pos == 0) {
            int value = (int) polynomial.charAt(pos);
            return value;
        } else {
            int ascii = (int) polynomial.charAt(pos);
            double result = ascii + (base * evaluatePolynomial(polynomial, pos - 1, base));
            return result;
        }
    }

    public double evaluateNonRecursivey(String polynomial, int base) {
        double hash = (int) polynomial.charAt(0);
        int x = 0;
        double y = 0;
        for (int i = 1; i < polynomial.length(); i++) {
            x = (int) polynomial.charAt(i);
            y = (hash * base);
            hash = (x + y);
        }
        return hash;
    }
}
