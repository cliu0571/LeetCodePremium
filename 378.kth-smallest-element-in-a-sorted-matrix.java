import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=378 lang=java
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 *
 * algorithms
 * Medium (51.52%)
 * Likes:    1828
 * Dislikes: 108
 * Total Accepted:    156.4K
 * Total Submissions: 298.9K
 * Testcase Example:  '[[1,5,9],[10,11,13],[12,13,15]]\n8'
 *
 * Given a n x n matrix where each of the rows and columns are sorted in
 * ascending order, find the kth smallest element in the matrix.
 * 
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth
 * distinct element.
 * 
 * 
 * Example:
 * 
 * matrix = [
 * ⁠  [ 1,  5,  9],
 * ⁠  [10, 11, 13],
 * ⁠  [12, 13, 15]
 * ],
 * k = 8,
 * 
 * return 13.
 * 
 * 
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ n^2.
 */

// @lc code=start
class MyNode {
    public int value;
    public int row;
    public int col;

    public MyNode(int value, int row, int col) {
        this.value = value;
        this.row = row;
        this.col = col;
    }
}

class MyHeapComparator implements Comparator<MyNode> {
    @Override
    public int compare(MyNode o1, MyNode o2) {
        return o1.value - o2.value;
    }

}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<MyNode> minHeap = new PriorityQueue<>(Math.min(n, k), new MyHeapComparator());
        for (int i = 0; i < Math.min(n, k); i++) {
            minHeap.offer(new MyNode(matrix[i][0], i, 0));
        }
        MyNode curr = minHeap.peek();
        while (k-- > 0) {
            curr = minHeap.poll();
            int row = curr.row;
            int col = curr.col;
            if (col < n - 1) {
                minHeap.offer(new MyNode(matrix[row][col + 1], row, col + 1));
            }
        }
        return curr.value;
    }
}
// @lc code=end
