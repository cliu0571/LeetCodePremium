/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    // T O(n) S O(1)
    public void flatten(TreeNode root) {

        // Handle the null scenario
        if (root == null) {
            return;
        }

        TreeNode node = root;

        while (node != null) {

            // if node has left
            if (node.left != null) {
                TreeNode rightmost = node.left;

                // find node.left's rightmost
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }

                // move node.left to node.right
                rightmost.right = node.right;
                node.right = node.left;
                node.left = null;
            }

            // move to next one
            node = node.right;
        }
    }
}
// @lc code=end
