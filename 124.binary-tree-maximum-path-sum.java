/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
  int max = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    getMax(root);
    return max;
  }

  private int getMax(TreeNode node) {
    if (node == null)
      return 0;

    // if left/right is neg nubmer, mark as 0
    int left = Math.max(0, getMax(node.left));
    int right = Math.max(0, getMax(node.right));

    max = Math.max(max, node.val + left + right);

    return node.val + Math.max(left, right);
  }
}
// @lc code=end