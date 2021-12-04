import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=171 lang=java
 *
 * [171] Excel Sheet Column Number
 */

// @lc code=start
class Solution {
    // T O(N) number of input chars S O(1)
    public int titleToNumber(String columnTitle) {
        int result = 0;

        Map<Character, Integer> alpha_map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            int c = i + 'A'; 
            alpha_map.put((char) c, i + 1);
        }

        int n = columnTitle.length();
        for (int i = 0; i < n; i++) {
            char cur_char = columnTitle.charAt(n - 1 - i);
            result += (alpha_map.get(cur_char) * (Math.pow(26, i)));
        }
        return result;
    }
}
// @lc code=end
