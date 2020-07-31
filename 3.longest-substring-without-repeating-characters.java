import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (29.24%)
 * Likes:    7103
 * Dislikes: 422
 * Total Accepted:    1.2M
 * Total Submissions: 4.2M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
 * ⁠            Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty())
            return 0;
        int max = 0;
        int length = s.length();
        int l = 0, r = 0;
        Set<Character> set = new HashSet<>();
        while (l < length && r < length) {
            if (!set.contains(s.charAt(r))) {
                set.add(s.charAt(r++));
                max = Math.max(max, r - l);
            } else {
                set.remove(s.charAt(l++));
            }
        }
        return max;
    }
}
// @lc code=end
