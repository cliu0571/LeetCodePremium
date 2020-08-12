/*
 * @lc app=leetcode id=875 lang=java
 *
 * [875] Koko Eating Bananas
 *
 * https://leetcode.com/problems/koko-eating-bananas/description/
 *
 * algorithms
 * Medium (52.04%)
 * Likes:    845
 * Dislikes: 73
 * Total Accepted:    43.3K
 * Total Submissions: 83.1K
 * Testcase Example:  '[3,6,7,11]\r\n8\r'
 *
 * Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has
 * piles[i] bananas.  The guards have gone and will come back in H hours.
 * 
 * Koko can decide her bananas-per-hour eating speed of K.  Each hour, she
 * chooses some pile of bananas, and eats K bananas from that pile.  If the
 * pile has less than K bananas, she eats all of them instead, and won't eat
 * any more bananas during this hour.
 * 
 * Koko likes to eat slowly, but still wants to finish eating all the bananas
 * before the guards come back.
 * 
 * Return the minimum integer K such that she can eat all the bananas within H
 * hours.
 * 
 * 
 * Example 1:
 * Input: piles = [3,6,7,11], H = 8
 * Output: 4
 * Example 2:
 * Input: piles = [30,11,23,4,20], H = 5
 * Output: 30
 * Example 3:
 * Input: piles = [30,11,23,4,20], H = 6
 * Output: 23
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int left = 1;
        int right = 1000000000;
        int mid = left;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (!isPossible(piles, H, mid)) {
                // mid is too small, target is in the right half
                left = mid + 1;
            } else {
                // mid is big, reduce it and try a smaller one since kolo want to eat slow
                right = mid;
            }
        }
        return left;
    }

    private boolean isPossible(int[] piles, int H, int K) {
        int time = 0;
        for (int p : piles) {
            time += (p - 1) / K + 1;
        }
        return time <= H;
    }
}
// @lc code=end
