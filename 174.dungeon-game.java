import java.util.Arrays;

/*
 * @lc app=leetcode id=174 lang=java
 *
 * [174] Dungeon Game
 */

// @lc code=start
class Solution {
    // T O(M*N), S O(M*N)
    int inf = Integer.MAX_VALUE;
    int[][] dp;
    int rows, cols;

    public int calculateMinimumHP(int[][] dungeon) {
        this.rows = dungeon.length;
        this.cols = dungeon[0].length;
        this.dp = new int[rows][cols];
        
        for (int[] arr : this.dp) {
            Arrays.fill(arr, this.inf);
        }

        for (int row = this.rows - 1; row >= 0; --row) {
            for (int col = this.cols - 1; col >= 0; --col) {
                int currCell = dungeon[row][col];

                int rightHealth = getMinHealth(currCell, row, col + 1);
                int downHealth = getMinHealth(currCell, row + 1, col);
                int nextHealth = Math.min(rightHealth, downHealth);

                int minHealth = inf;
                if (nextHealth != inf) {
                    minHealth = nextHealth;
                } else {
                    minHealth = currCell >= 0 ? 1 : 1 - currCell;
                }
                this.dp[row][col] = minHealth;
            }
        }
        return this.dp[0][0];
    }
    
    public int getMinHealth(int currCell, int nextRow, int nextCol) {
        if (nextRow >= this.rows || nextCol >= this.cols)
            return inf;
        int nextCell = this.dp[nextRow][nextCol];
        // hero needs at least 1 point to survive
        return Math.max(1, nextCell - currCell);
    }
}
// @lc code=end
