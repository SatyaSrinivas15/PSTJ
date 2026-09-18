import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {

        List<Integer> marks = Arrays.asList(45, 78, 32, 90, 65, 88, 40, 95);

        List<Integer> updatedMarks = marks.stream()
                .filter(m -> m >= 60)
                .map(m -> m + 5)
                .collect(Collectors.toList());

        double average = updatedMarks.stream()
                .mapToInt(m -> m)
                .average()
                .orElse(0.0);

        List<Integer> descendingMarks = updatedMarks.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("Marks greater than or equal to 60:");
        System.out.println(updatedMarks);

        System.out.println("Average of updated marks: " + average);

        System.out.println("Marks in descending order:");
        System.out.println(descendingMarks);
    }
}