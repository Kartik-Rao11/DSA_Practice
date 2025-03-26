/**
 * Leetcode question link :
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach :
 * 1. Count the number of vowels for 0 to k. This will be the maxVowels for now
 * 2. Iterate the rest of the String from K to string.length().
 * 3. For elements going out of window i-k if that is a vowel we will decrease
 * the current vowel count.
 * 4. For current element if that is vowel increment count.
 * 
 * Time complexity -> O(N)
 * 
 */

class Solution {
    public int maxVowels(String s, int k) {
        int maxVowels = 0, currentVowels = 0;
        String vowels = "aeiou";
        for (int i = 0; i < k; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                currentVowels++;
            }
        }

        maxVowels = currentVowels;
        for (int i = k; i < s.length(); i++) {

            if (vowels.indexOf(s.charAt(i - k)) != -1) {
                currentVowels--;
            }

            if (vowels.indexOf(s.charAt(i)) != -1) {
                currentVowels++;
            }

            maxVowels = Math.max(maxVowels, currentVowels);

        }

        return maxVowels;
    }
}