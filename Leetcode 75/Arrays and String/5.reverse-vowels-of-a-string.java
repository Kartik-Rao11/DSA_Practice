
/**
 * Leetcode Question link :
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach :
 * 1. Two pointer Approach -> One pointer from left and one from right find
 * vowels and swap them
 * 
 * Time complexity -> O(n)
 */

class Solution {
    public String reverseVowels(String s) {

        int left = 0, right = s.length() - 1;
        char[] arr = s.toCharArray();
        while (left <= right) {
            while (left < right && !isVowel(s.charAt(left))) {
                left++;
            }

            while (left < right && !isVowel(s.charAt(right))) {
                right--;
            }

            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        return new String(arr);
    }

    boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}