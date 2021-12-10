/*
 * @lc app=leetcode id=258 lang=java
 *
 * [258] Add Digits
 */

// @lc code=start
class Solution {
    // T O(1) S O(1)
    public int addDigits(int num) {
        if (num == 0)
            return 0;
            
        if (num % 9 == 0)
            return 9;
            
        return num % 9;
    }
}
// @lc code=end
