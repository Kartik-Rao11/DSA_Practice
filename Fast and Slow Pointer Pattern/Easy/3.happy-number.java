/**
 * Leetcode question link:
 * https://leetcode.com/problems/happy-number/description/
 * 
 * Approach: (fast and slow pointer)
 * 1. move the fast doulbe and slow by one step. Move-> sum of square of digits
 * 2. if fast and slow meet -> cycle exists
 * 3. check the value of slow or fast. if equal to 1 return else false
 * 
 */

class Solution {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        while (true) {
            fast = findSquareOfDigits(findSquareOfDigits(fast));
            slow = findSquareOfDigits(slow);
            if (fast == slow) {
                break;
            }
        }

        return slow == 1;
    }

    public int findSquareOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num = num / 10;
        }
        return sum;
    }
}
