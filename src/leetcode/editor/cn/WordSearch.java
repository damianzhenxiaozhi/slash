//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SE
//E"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 
// 👍 952 👎 0


package leetcode.editor.cn;

public class WordSearch {
    public static void main(String[] args) {
        Solution s = new WordSearch().new Solution();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(s.exist(board, word));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int m;
        private int n;
        private boolean found;

        public boolean exist(char[][] board, String word) {
            m = board.length;
            n = board[0].length;
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dfs(board, i, j, word.toCharArray(), 0, visited);
                }
            }
            return found;
        }

        private void dfs(char[][] board, int i, int j, char[] word, int k, boolean[][] visited) {
            if (found) {
                return;
            }

            if (board[i][j] != word[k]) {
                return;
            }

            if (k == word.length - 1) {
                found = true;
                return;
            }

            visited[i][j] = true;
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int r = 0; r < directions.length; r++) {
                int ii = i + directions[r][0];
                int jj = j + directions[r][1];
                if (ii >= 0 && ii < m && jj >= 0 && jj < n && !visited[ii][jj]) {
                    dfs(board, ii, jj, word, k + 1, visited);
                }
            }
            visited[i][j] = false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
