import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 *
 * https://leetcode.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (44.52%)
 * Likes:    1342
 * Dislikes: 58
 * Total Accepted:    250.5K
 * Total Submissions: 553.2K
 * Testcase Example:  '[1,2,2]'
 *
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,2]
 * Output:
 * [
 * ⁠ [2],
 * ⁠ [1],
 * ⁠ [1,2,2],
 * ⁠ [2,2],
 * ⁠ [1,2],
 * ⁠ []
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        dfsHelper(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    private void dfsHelper(List<List<Integer>> ans, List<Integer> temp, int[] nums, int start) {
        ans.add(new ArrayList<>(temp));
        Set<Integer> visited = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (visited.add(nums[i])) {
                temp.add(nums[i]);
                dfsHelper(ans, temp, nums, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

}
// @lc code=end
