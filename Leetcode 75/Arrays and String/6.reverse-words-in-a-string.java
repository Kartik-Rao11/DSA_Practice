import java.util.Arrays;
import java.util.Collections;

/**
 * Leetcode question link :
 * https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 */

class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}