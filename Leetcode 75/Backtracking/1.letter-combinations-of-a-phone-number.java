
/**
 * Leetcode question link :
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach :
 * For the input number we need to generate all possible combinations of letters
 * it could form.
 * The intuition behind the solution is that we can solve the problem using a
 * form of backtracking—generating all the possible combinations by traversing
 * over the input digits and mapping them to the corresponding letters. We start
 * with an initial list containing just an empty string, which represents the
 * starting point of our combination. For each digit in the input string, we
 * look up the corresponding string of characters it can represent and then
 * generate new combinations by appending each of these letters to each of the
 * combinations we have so far.
 * 
 * Steps:
 * 1. Define result array list with empty string.
 * 2. Define array of keypad words
 * 3. Iterate over the given digit.
 * 4. For every digit get the corresponding words from keyPad array.
 * 5. Now to generate combination define temp array list.
 * 6. For our current word we need to map it's every letter to every string or
 * word that is already in the result.
 * 
 * Time complexity -> O(4^N)
 * 
 */
import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }

        result.add("");

        String[] phoneString = new String[] { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        for (char c : digits.toCharArray()) {
            String word = phoneString[c - '2'];
            List<String> temp = new ArrayList<>();
            for (String combination : result) {
                for (char letter : word.toCharArray()) {
                    temp.add(combination + letter);
                }
            }

            result = temp;
        }

        return result;
    }
}