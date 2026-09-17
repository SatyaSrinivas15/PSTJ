package javalab;

import java.util.*;
import java.util.function.BiFunction;
public class Task9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine().trim();
        String[] parts = expression.split("\\s+");
        int a = Integer.parseInt(parts[0]);
        String operator = parts[1];
        int b = Integer.parseInt(parts[2]);
        BiFunction<Integer, Integer, Integer> addition =
                (x, y) -> x + y;
        BiFunction<Integer, Integer, Integer> division =
                (x, y) -> {
                    if (y == 0) {
                        throw new ArithmeticException("Cannot divide by zero");
                    }
                    return x / y;
                };
        int result;
        if (operator.equals("+")) {
            result = addition.apply(a, b);
            if (result == a + b) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
        } else if (operator.equals("/")) {
            try {
                result = division.apply(a, b);
                if (result == a / b) {
                    System.out.println("Test Passed");
                } else {
                    System.out.println("Test Failed");
                }
            } catch (ArithmeticException e) {
                System.out.println("Test Failed");
            }
        }
        sc.close();
    }
}