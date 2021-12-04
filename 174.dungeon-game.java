import java.util.Arrays;

/*
 * @lc app=leetcode id=174 lang=java
 *
 * [174] Dungeon Game
 */

// @lc code=start
class Solution {
    // T O(M*N), S O(M*N)
    int[][] dp;
    int rows, cols;

    public int calculateMinimumHP(int[][] dungeon) {
        this.rows = dungeon.length;
        this.cols = dungeon[0].length;
        this.dp = new int[rows][cols];

        for (int[] arr : this.dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        for (int row = this.rows - 1; row >= 0; --row) {
            for (int col = this.cols - 1; col >= 0; --col) {
                int currCell = dungeon[row][col];

                int goRight = getMinHealth(currCell, row, col + 1);
                int goDown = getMinHealth(currCell, row + 1, col);
                int nextHp = Math.min(goRight, goDown);

                int minHp = 1;
                if (nextHp != Integer.MAX_VALUE) {
                    minHp = nextHp;
                } else {
                    minHp = currCell >= 0 ? 1 : 1 - currCell;
                }
                dp[row][col] = minHp;
            }
        }
        return this.dp[0][0];
    }

    public int getMinHealth(int currCell, int nextRow, int nextCol) {
        if (nextRow >= this.rows || nextCol >= this.cols)
            return Integer.MAX_VALUE;
        int nextCell = this.dp[nextRow][nextCol];
        // hero needs at least 1 point to survive
        return Math.max(1, nextCell - currCell);
    }
}
// @lc code=end
