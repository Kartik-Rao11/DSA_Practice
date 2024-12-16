/**
 * Leet code question link
 * https://leetcode.com/problems/backspace-string-compare/description/
 */

class Solution {
    public boolean backspaceCompare(String s, String t) {

        int p1 = s.length() - 1;
        int p2 = t.length() - 1;
        while (p1 >= 0 || p2 >= 0) {
            int i = getNextChar(s, p1);
            int j = getNextChar(t, p2);

            if (i < 0 && j < 0) {
                return true;
            }

            if (i < 0 || j < 0) {
                return false;
            }

            if (s.charAt(i) != t.charAt(j)) {
                return false;
            }

            p1 = i - 1;
            p2 = j - 1;
        }

        return true;
    }

    public int getNextChar(String str, int index) {
        int backspace = 0;
        while (index >= 0) {

            if (str.charAt(index) == '#') {
                backspace++;
            } else if (backspace > 0) {
                backspace--;
            } else {
                break;
            }

            index--;
        }

        return index;
    }
}