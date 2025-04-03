/**
 * Leetcode question link :
 * https://leetcode.com/problems/number-of-provinces/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * To find the solution, we conceptualize the cities and the connections between
 * them as a graph, where each city is a node and each direct connection is an
 * edge. Now, the problem translates to finding the number of connected
 * components in the graph. Each connected component will represent one
 * province.
 * 
 * To do this, we use Depth-First Search (DFS). Here's the intuition behind
 * using DFS:
 * 
 * We start with the first city and perform a DFS to mark all cities that are
 * connected directly or indirectly to it. These cities form one province.
 * Once the DFS is completed, we look for the next city that hasn't been visited
 * yet and perform a DFS from that city to find another province.
 * We repeat this process until all cities have been visited.
 * Each time we initiate a DFS from a new unvisited city, we know that we've
 * found a new province, so we increment our province count. The DFS ensures
 * that we navigate through all the cities within a province before moving on to
 * the next one.
 * 
 * By doing the above steps using a vis (visited) list to keep track of which
 * cities have been visited, we can effectively determine and count all the
 * provinces.
 */

class Solution {
    int[][] isConnected;
    boolean[] vis;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        this.isConnected = isConnected;
        this.vis = new boolean[n];
        int numProvince = 0;
        for (int i = 0; i < n; i++) {
            if (!this.vis[i]) {
                dfs(i);
                numProvince++;
            }
        }

        return numProvince;

    }

    public void dfs(int cityIndex) {

        this.vis[cityIndex] = true;

        for (int destination = 0; destination < this.isConnected.length; destination++) {

            if (!this.vis[destination] && this.isConnected[cityIndex][destination] == 1) {
                dfs(destination);
            }
        }
    }
}