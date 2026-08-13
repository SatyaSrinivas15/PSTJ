package javalab;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int first = sc.nextInt();
        int currentSum = first;
        int maxSum = first;

        for (int i = 1; i < n; i++) {
            int value = sc.nextInt();

            currentSum = Math.max(value, currentSum + value);
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);
        sc.close();
    }
}