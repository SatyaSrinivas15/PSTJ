package javalab;

import java.util.*;
import java.util.stream.*;

public class task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Sensor> readings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String id = sc.next();
            double temperature = sc.nextDouble();
            readings.add(new Sensor(id, temperature));
        }

        readings.stream()
                .filter(r -> r.temperature > 50)
                .collect(Collectors.groupingBy(
                        r -> r.sensorId,
                        Collectors.averagingDouble(r -> r.temperature)
                ))
                .entrySet()
                .stream()
                .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
        sc.close();
    }

    static class Sensor {
        String sensorId;
        double temperature;

        Sensor(String sensorId, double temperature) {
            this.sensorId = sensorId;
            this.temperature = temperature;
        }
    }
}