import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    // BFS T: O(n) S: O(n)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        // Add nodes from left to right to this queue
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int size = 1;

        boolean isLeft2Right = true;

        while (!q.isEmpty()) {
            // add values of current level here
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (isLeft2Right) {
                    temp.add(curr.val);
                } else {
                    temp.addFirst(curr.val);
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            result.add(temp);
            isLeft2Right = !isLeft2Right;
            size = q.size();
        }
        return result;
    }
}
// @lc code=end
