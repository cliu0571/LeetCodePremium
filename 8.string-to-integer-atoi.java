/*s
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0)
            return 0;
        s = s.trim();
        if (s.equals("")) return 0;
        char firstChar = s.charAt(0);
        int sign = 1, start = 0, len = s.length();
        long sum = 0;
        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }
        for (int i = start; i < len; i++) {
            if (!Character.isDigit(s.charAt(i)))
                return (int) sum * sign;
            sum = sum * 10 + s.charAt(i) - '0';
            if (sign == 1 && sum > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }

        return (int) sum * sign;
    }
}
// @lc code=end
