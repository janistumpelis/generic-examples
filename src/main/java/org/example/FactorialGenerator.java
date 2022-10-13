package org.example;

public class FactorialGenerator {

    public int generate(int number) {
        if (number < 0) {
            throw new FactorialException("Cannot pass in values below zero!");
        }
        return factorial(number);
    }

    private int factorial(int number) {
        if (number == 0) {
            return 1;
        }
        return number * factorial(number - 1);
    }

}
