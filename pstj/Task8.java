package javalab;

import java.util.*;
public class Task8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int source = sc.nextInt();
        int destination = sc.nextInt();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited.add(source);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            graph.getOrDefault(current, Collections.emptyList())
                 .stream()
                 .filter(node -> !visited.contains(node))
                 .forEach(node -> {
                     visited.add(node);
                     queue.add(node);
                 });
        }
        System.out.println(
            visited.contains(destination) ? "YES" : "NO"
        );
        sc.close();
    }
}