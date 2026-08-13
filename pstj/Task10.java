package javalab;

import java.util.*;
import java.util.function.Predicate;

public class Task10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String[]> users = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String username = sc.next();
            String password = sc.next();
            users.add(new String[]{username, password});
        }
        Predicate<String> validUsername =
                username -> username.length() >= 3 && username.length() <= 20;
        Predicate<String> validPassword =
                password -> password.length() >= 6 && password.length() <= 20;
        Predicate<String[]> authenticate = login ->
                validUsername.test(login[0]) &&
                validPassword.test(login[1]) &&
                (
                    (login[0].equals("admin") && login[1].equals("admin123")) ||
                    (login[0].equals("user") && login[1].equals("user123"))
                );
        users.stream()
             .map(authenticate::test)
             .map(result -> result ? "SUCCESS" : "FAILURE")
             .forEach(System.out::println);
        sc.close();
    }
}
