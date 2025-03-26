import java.util.*;

/**
 * Leetcode Question Link:
 * https://leetcode.com/problems/determine-if-two-strings-are-close/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Two strings are considered close if you can attain one from the other using
 * the following operations:
 * 
 * Operation 1: Swap any two existing characters.
 * For example, abcde -> aecdb
 * Operation 2: Transform every occurrence of one existing character into
 * another existing character, and do the same with the other character.
 * For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into
 * a's)
 * 
 * Approach:
 * 1. Check if the length of two string are equal if yes -> they are swapable
 * operation 1 true proceed for further check else return false.
 * 
 * 2. create two frequency array of length 26 and hashSet of character for both
 * word1 and word2.
 * 
 * 3. Iterate over the words and add increase the frequencies and add individual
 * char of words to set respectively.
 * 
 * 4. Check if the word1 and word2 have same set of the characters ex : word1 =
 * (aabbc), word2 = (aaaabbbbbcccc), then set1 :{a,b,c} = set2:{a,b,c} if yes
 * then can be close procced for check for if the same number of characters can
 * we swapped else return false
 * 
 * 5. Now sort the frequencies array and if they are equal then we swap the same
 * number of char with each other return true else false
 * 
 */

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        int[] freq1 = new int[26], freq2 = new int[26];
        Set<Character> set1 = new HashSet<>(), set2 = new HashSet<>();
        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++; // small a asscii value = 26, so for char a = 26 - 26, freq[0], char b = 27 -
                              // 26, freq[1]
            set1.add(c);
        }

        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
            set2.add(c);
        }

        if (!set1.equals(set2))
            return false;

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);

    }
}