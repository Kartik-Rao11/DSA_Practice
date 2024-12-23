
/**
 * Leet code question link :
 * https://leetcode.com/problems/meeting-rooms-ii/description/
 * 
 * Given a list of intervals representing the start and endTime ofN meetings,
 * find the minimum number of rooms required to hold all the meetings.
 * 
 * Approach:
 * 1. Sort the interval according to their start times.
 * 2. if currentMeeting's start time >= previousMeeting's end time. No need of
 * room can be perfomed in the same room. else we need a room as the intervals
 * are merging. Update the previous the end.
 * 3. We can create minHeap that will return the previous meeting end time and
 * we can compare.
 * 
 * Similar questions:
 * Given a list of intervals, find the point where the maximum number of intervals overlap.
 * Given a list of intervals representing the arrival and departure times of trains to a train station, 
 * our goal is to find the minimum number of platforms required for the train station so that no train has to wait.
 */

import java.util.*;

class Solution {

    public int minRooms(int[][] meetings) {
        if (meetings == null)
            return -1;
        if (meetings.length == 1)
            return 1;
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        rooms.add(meetings[0][1]);
        for (int i = 1; i < meetings.length; i++) {
            // previou end <= new's start
            if (rooms.peek() <= meetings[i][0]) {
                // we don't need new room can use the same room
                rooms.poll();
            }
            rooms.add(meetings[i][1]);
        }

        return rooms.size();
    }
}