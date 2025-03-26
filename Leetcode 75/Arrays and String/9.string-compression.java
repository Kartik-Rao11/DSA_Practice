/**
 * Leetcode quetion link :
 * https://leetcode.com/problems/string-compression/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach :
 * 1. Initialize the write = 0 pointer for writing in the array.
 * 2. Use while loop to iterate through the char array.
 * 3. Get the current Char and again using while loop get's it total count in
 * the array while incrementing the count.
 * 4. Write the current char in the char array and convert the number count to
 * string and then char array and loop for each char to map double digit value
 * like 10 -> "1", "0".
 * 
 * Time complexity -> O(n)
 */

class Solution {
    static {
        for (int i = 0; i < 500; i++)
            compress(null);
    }

    public static int compress(char[] chars) {
        if (chars == null)
            return 0;
        int write = 0;
        int i = 0;
        while (i < chars.length) {
            char currChar = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == currChar) {
                i++;
                count++;
            }

            chars[write++] = currChar;
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[write++] = c;

                }
            }
        }
        return write;
    }
}