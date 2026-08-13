import java.util.*;
import java.util.stream.Collectors;

public class Task1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> salaries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            salaries.add(sc.nextInt());
        }
        List<Integer> updatedSalaries = salaries.stream()
                .map(salary -> salary + (salary * 10 / 100))
                .collect(Collectors.toList());
        for (int i = 0; i < updatedSalaries.size(); i++) {
            System.out.print(updatedSalaries.get(i));
            if (i != updatedSalaries.size() - 1) {
                System.out.print(" ");
            }
        }
        sc.close();
    }
}