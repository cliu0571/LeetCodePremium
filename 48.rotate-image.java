/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int length = matrix.length;

        // transpose matrix
        for (int row = 0; row < length; row++) {
            for (int col = row; col < length; col++) {
                if (row == col) {
                    continue;
                } else {
                    int temp = matrix[row][col];
                    matrix[row][col] = matrix[col][row];
                    matrix[col][row] = temp;
                }
            }
        }

        // reflect matrix
        for (int row = 0; row < length; row++) {
            for (int col = 0; col < length / 2; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][length - col - 1];
                matrix[row][length - col - 1] = temp;
            }
        }
    }

}
// @lc code=end
