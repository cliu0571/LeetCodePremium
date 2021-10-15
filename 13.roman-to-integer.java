import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int i = 0;
        while (i < s.length()) {
            int curr = values.get(s.charAt(i));
            int next = 0;
            if (i + 1 < s.length()) {
                next = values.get(s.charAt(i + 1));
            }
            if (curr < next) {
                sum += (next - curr);
                i += 2;
            } else {
                sum += curr;
                i += 1;
            }
        }
        return sum;
    }

    static Map<Character, Integer> values = new HashMap<>();

    static {
        values.put('M', 1000);
        values.put('D', 500);
        values.put('C', 100);
        values.put('L', 50);
        values.put('X', 10);
        values.put('V', 5);
        values.put('I', 1);
    }
}

// @lc code=end
