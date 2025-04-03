
/**
 * Leetcode question link :
 * https://leetcode.com/problems/keys-and-rooms/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * We can visit 0th room and after that we need to search for keys and after
 * getting apply dfs on that keys.
 * Keep a set of visited index so that if we try to enter already visited room
 * it should return from there.
 * Check if the visted set size == room.size() means we have visited every room
 * else false.
 */
import java.util.*;

class Solution {
    Set<Integer> vis = new HashSet<>();
    List<List<Integer>> rooms;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        this.rooms = rooms;
        dfs(0);
        return vis.size() == rooms.size();

    }

    public void dfs(int roomIndex) {
        if (vis.contains(roomIndex)) {
            return;
        }

        vis.add(roomIndex);
        for (int key : rooms.get(roomIndex)) {
            dfs(key);
        }
    }
}