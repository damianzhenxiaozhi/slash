//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 1221 👎 0


package leetcode.editor.cn;

public class NumberOfIslands {
    public static void main(String[] args) {
        Solution s = new NumberOfIslands().new Solution();
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
        System.out.println(s.numIslands(grid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            int count = 0;

            int m = grid.length;
            if (m == 0) {
                return count;
            }
            int n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        dfsTraverse(grid, m, n, i, j);
                        count++;
                    }
                }
            }

            return count;
        }

        private void dfsTraverse(char[][] grid, int m, int n, int i, int j) {
            grid[i][j] = '2';

            int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int k = 0; k < direction.length; k++) {
                int ii = i + direction[k][0];
                int jj = j + direction[k][1];
                if (isValid(ii, jj, m, n) && grid[ii][jj] == '1') {
                    dfsTraverse(grid, m, n, ii, jj);
                }
            }
        }

        private boolean isValid(int i, int j, int m, int n) {
            return i >= 0 && i < m && j >=0 && j < n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
