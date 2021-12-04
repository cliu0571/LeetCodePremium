/*
 * @lc app=leetcode id=168 lang=java
 *
 * [168] Excel Sheet Column Title
 */

// @lc code=start
class Solution {
    public String convertToTitle(int columnNumber) {
        return columnNumber == 0 ? "" : convertToTitle(--columnNumber / 26) + (char) ('A' + (columnNumber % 26));
    }
}
// @lc code=end
