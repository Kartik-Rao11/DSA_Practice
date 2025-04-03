
/**
 * Leetcode question link :
 * https://leetcode.com/problems/evaluate-division/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * This problem can be solved using Graph Traversal (DFS or BFS). The key idea
 * is to represent the given equations as a directed weighted graph, where each
 * variable is a node, and each equation represents a directed edge with a
 * weight equal to the division value.
 * 
 * Graph Representation
 * 
 * Treat each variable as a node.
 * 
 * Each equation A / B = value is represented as:
 * 
 * A → B (weight = value)
 * 
 * B → A (weight = 1 / value)
 * 
 * Handling Queries
 * 
 * If C or D is not in the graph, return -1.0.
 * 
 * Use DFS or BFS to search for a path from C to D, accumulating the product of
 * weights along the path.
 * 
 * Algorithm
 * Build the Graph
 * 
 * Use a HashMap<String, HashMap<String, Double>> (graph) to store edges and
 * weights.
 * 
 * Store both direct (A → B = value) and reverse (B → A = 1 / value)
 * relationships.
 * 
 * Process Queries
 * 
 * If C or D is missing, return -1.0.
 * 
 * Use DFS (or BFS) to find a path from C to D, multiplying the edge weights
 * along the way.
 * 
 * Find path C to D -> Get the neighbour of C, check if it is already been
 * visited if not again send it to dfs with it's weight value multiplied with
 * current value. Unitl we reach the D and return the value.
 * 
 * Time complexity -> O(E) -> to build graph from number of equations (E)
 * O(Q*V) -> No. of queries (Q) and vairables (V) on which dfs is applied
 * 
 * Total time complexity -> O (E + QV)
 * 
 */
import java.util.*;

class Solution {
    Map<String, Map<String, Double>> graph = new HashMap<>();
    Set<String> vis = new HashSet<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];
            graph.computeIfAbsent(a, k -> new HashMap<>()).put(b, value);
            graph.computeIfAbsent(b, k -> new HashMap<>()).put(a, 1 / value);
        }

        for (int i = 0; i < queries.size(); i++) {
            String c = queries.get(i).get(0);
            String d = queries.get(i).get(1);

            if (!graph.containsKey(c) || !graph.containsKey(d)) {
                result[i] = -1.0;
            } else {
                vis.clear();
                result[i] = dfs(c, d, 1.0);
            }
        }

        return result;
    }

    public double dfs(String current, String target, double value) {
        if (current.equals(target))
            return value;
        vis.add(current);

        for (Map.Entry<String, Double> neighbour : graph.get(current).entrySet()) {
            if (!vis.contains(neighbour.getKey())) {
                double result = dfs(neighbour.getKey(), target, neighbour.getValue() * value);
                if (result != -1.0)
                    return result;
            }
        }

        return -1.0;
    }
}