// import java.util.*;

class Solution {
    // Helper class to store graph edges
    class Edge {
        String neighbor;
        double weight;
        
        Edge(String neighbor, double weight) {
            this.neighbor = neighbor;
            this.weight = weight;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Step 1: Build the graph
        Map<String, List<Edge>> graph = new HashMap<>();
        
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());

            graph.get(u).add(new Edge(v, val));
            graph.get(v).add(new Edge(u, 1.0 / val));
        }

        // Step 2: Process each query
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            // Check if start or end nodes exist in graph
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                result[i] = -1.0;
            } else if (start.equals(end)) {
                result[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                result[i] = dfs(start, end, 1.0, graph, visited);
            }
        }

        return result;
    }

    private double dfs(String current, String target, double accProduct, Map<String, List<Edge>> graph, Set<String> visited) {
        if (current.equals(target)) {
            return accProduct;
        }

        visited.add(current);

        for (Edge edge : graph.get(current)) {
            if (!visited.contains(edge.neighbor)) {
                double ans = dfs(edge.neighbor, target, accProduct * edge.weight, graph, visited);
                if (ans != -1.0) {
                    return ans; // Path found
                }
            }
        }

        return -1.0; // No valid path found
    }
}