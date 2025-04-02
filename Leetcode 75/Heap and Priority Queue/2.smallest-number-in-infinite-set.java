
/**
 * Leetcode question link :
 * https://leetcode.com/problems/smallest-number-in-infinite-set/?envType=study-plan-v2&envId=leetcode-75
 * 
 * You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].
 * 
 * Implement the SmallestInfiniteSet class:
 * 
 * SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain
 * all positive integers.
 * int popSmallest() Removes and returns the smallest integer contained in the
 * infinite set.
 * void addBack(int num) Adds a positive integer num back into the infinite set,
 * if it is not already in the infinite set.
 * 
 * Approach:
 * We can see that we need operations like poping the smallest element and
 * adding the num if it is not in set. We can use heap and set.
 * Heap to pop the smallest element and set to check is already in the set or
 * not.
 * 
 * Since we have infinite set on initalizing it if we pop the smallest pop
 * should be 1 next pop will be 2
 * The nextSmallest = 1,
 * 
 * On adding element check if it is less than nextSmallest and it should'nt be
 * in set. then add it to minHeap and set.
 * 
 * On poping the elements check if the minHeap is empty. if yes-> return the
 * nextSmallest according to initialization of the class and increment the
 * nextSmallest.
 * if not empty -> poll the smallest element from the heap remove it from the
 * set and return it.
 * 
 */
import java.util.*;

class SmallestInfiniteSet {
    PriorityQueue<Integer> minHeap;
    Set<Integer> set;
    int nextSmallest;

    public SmallestInfiniteSet() {
        minHeap = new PriorityQueue<>();
        set = new HashSet<>();
        nextSmallest = 1;
    }

    public int popSmallest() {

        if (!minHeap.isEmpty()) {
            int smallest = minHeap.poll();
            set.remove(smallest);
            return smallest;
        }

        return nextSmallest++;
    }

    public void addBack(int num) {
        if (num < nextSmallest && !set.contains(num)) {
            minHeap.add(num);
            set.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */