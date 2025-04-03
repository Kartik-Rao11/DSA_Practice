
/**
 * Leetcode question link:
 * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * The underlying concept of the solution is Depth-First Search (DFS). We employ
 * DFS because it effectively explores all the paths from the root to the leaves
 * in a tree, which aligns well with the nature of our problem — ensuring
 * connectivity in a tree from every node to the root.
 * 
 * To solve the problem, we treat the graph as undirected to explore it freely.
 * However, we have to remember the initial direction of the roads.
 * Consequently, as we perform DFS starting from the capital city (node 0), we
 * keep a set of tuples s representing the original direction of the roads.
 * 
 * Everytime exploring the neighbouring cities from dfs we encounter a path
 * which represent the original direction of the road we need to change it as we
 * need cities to reach root node 0. we again call dfs with neighbouring cities
 * to explore all it's path.
 * 
 * The process is recursive — from each city we visit, we attempt to visit all
 * other cities it is connected to (that we have not already visited), keeping
 * track of the roads we need to change.
 * 
 * How are we making the graph undirected?
 * Undirected graph-> A node which is connected to it's neighbouring nodes
 * irrespective of the direction.
 * 
 * For every node or city map all the possible connections it have irrespective
 * of directions.
 * 
 * graph.computeIfAbsent(a,k-> new ArrayList<>()).add(b);
 * graph.computeIfAbsent(b,k-> new ArrayList<>()).add(a);
 * 
 * this code helps to form the undirected graph.
 * In this we have key as city and it's values are the arrayList representing
 * the neighbouring cities.
 * What it does
 * Ensures that a key exists in the graph map
 * 
 * If key a is not in graph, it creates an empty ArrayList<> for a.
 * 
 * If key b is not in graph, it creates an empty ArrayList<> for b.
 * 
 * Adds an edge between a and b in both directions
 * 
 * Adds b to a's adjacency list → a → b
 * 
 * Adds a to b's adjacency list → b → a
 * 
 * This makes the graph undirected (bidirectional).
 * 
 * If a exists in the map → Returns its ArrayList<> and adds b to it.
 * 
 * If a does not exist → Creates a new ArrayList<>, adds it to the map, and then
 * adds b to it.
 * 
 * For input = int[][] connections = {{0,1}, {1,3}, {2,3}, {4,0}, {4,5}};
 * 
 * This is the example of undirected graph
 * 
 * {
 * 0 = [1, 4],
 * 1 = [0, 3],
 * 2 = [3],
 * 3 = [1, 2],
 * 4 = [0, 5],
 * 5 = [4]
 * }
 * 
 * Time complexity -> O(N)
 */
import java.util.*;

class Solution {
    Map<Integer, List<Integer>> graph;
    Set<String> directEdges;

    public int minReorder(int n, int[][] connections) {
        this.graph = new HashMap<>();
        this.directEdges = new HashSet<>();
        for (int[] conn : connections) {
            int a = conn[0];
            int b = conn[1];
            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
            this.directEdges.add(a + "," + b);
        }

        return dfs(0, -1);

    }

    public int dfs(int city, int parent) {
        int count = 0;
        for (int neighbour : graph.getOrDefault(city, new ArrayList<>())) {
            if (parent == neighbour)
                continue;

            if (this.directEdges.contains(city + "," + neighbour)) {
                count++;
            }

            count += dfs(neighbour, city);
        }

        return count;
    }
}
