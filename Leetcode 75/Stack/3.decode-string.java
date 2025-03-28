import java.util.*;
/**
 * Leetcode question link :
 * https://leetcode.com/problems/decode-string/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Given an encoded string, return its decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * You may assume that the input string is always valid; there are no extra
 * white spaces, square brackets are well-formed, etc. Furthermore, you may
 * assume that the original data does not contain any digits and that digits are
 * only for those repeat numbers, k. For example, there will not be input like
 * 3a or 2[4].
 * 
 * Example 1:
 * 
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 * 
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * 
 * Approach:
 * we need to decode the encoded string. the number before opening bracket
 * determines the number of time a string is repeated -> the string that is to
 * be repeated is the square brackets, so string between square brackets is the
 * actually string we are decoding.
 * 
 * We can observe two behaviour,
 * 1. The order in which the string is encoded is we
 * have the number then the string.
 * 2. And for complex brackets "3[a2[c]]" we need to make sure we first process
 * the simple opening and closing bracket[].
 * 
 * We can say if we encounter a closing bracket, we need to process the elements
 * before it and hence we can use stack like structure.
 * 
 * Steps:
 * 1. Use two stack one to count the number and other to store the decoded
 * string.
 * 2. Iterate through the string
 * if (char is number ) save it's value handling the more the one's place
 * if( opening bracker "[" ) we need to process the elements
 * now we have the count so push it into the count stack
 * since it is an opening bracket there can be a case of some string value
 * before it like ab3[c] -> abccc
 * push the currString that is ab into stack -> ab is currString until we
 * encountered the new opening bracket which is indication of new string.
 * 
 * if(closing ]) we need to finally decode the string
 * get the repeat count of string from count stack
 * get the decoded string from string stack. decoded string is the string we
 * encountered before a new opening bracket, since we are at closing bracket we
 * are processing the current string in between opening and closing bracket
 * loop according to count and append the currString to decoded string
 * 
 * if(string value) append it to currString string we are currently processing
 * 
 * return the string
 * 
 */

class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currString = new StringBuilder();
        int num = 0;
        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(num);
                stringStack.push(currString);
                num = 0;
                currString = new StringBuilder();
            } else if (c == ']') {
                int repeatCount = countStack.pop();
                StringBuilder decodedString = stringStack.pop();

                for (int i = 0; i < repeatCount; i++) {
                    decodedString.append(currString);
                }

                currString = decodedString;
            } else {
                currString.append(c);
            }
        }

        return currString.toString();
    }
}