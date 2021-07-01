//编写一个程序，通过填充空格来解决数独问题。 
//
// 数独的解法需 遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 
//
// 
// 
// 
// 示例： 
//
// 
//输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5","."
//,".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".","."
//,"3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"
//],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],["
//.",".",".",".","8",".",".","7","9"]]
//输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"
//],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["
//4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","
//6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","
//5","2","8","6","1","7","9"]]
//解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
//
//
// 
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字或者 '.' 
// 题目数据 保证 输入数独仅有一个解 
// 
// 
// 
// 
// Related Topics 数组 回溯 矩阵 
// 👍 869 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {
        Solution s = new SudokuSolver().new Solution();
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        s.solveSudoku(board);

        System.out.println(Arrays.deepToString(board));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private boolean find = false;

        public void solveSudoku(char[][] board) {
            int n = board.length;
            backTrace(board, n, 0);
        }

        private void backTrace(char[][] board, int n, int k) {
            // 决策完，找到唯一解
            if (k >= n * n) {
                find = true;
                return;
            }

            int i = k / n;
            int j = k % n;
            while (board[i][j] != '.') {
                k++;
                i = k / n;
                j = k % n;
            }

            char[] canBeSelected = calcCanBeSelected(board, n, i, j);
            for (char c : canBeSelected) {
                board[i][j] = c;
                backTrace(board, n, k + 1);
                if (find) {
                    return;
                }
                board[i][j] = '.';
            }
        }

        private char[] calcCanBeSelected(char[][] board, int n, int i, int j) {
            char[] nums = new char[10];
            for (int k = 0; k < 10; k++) {
                nums[k] = (char) ('0' + k);
            }

            // 排除行的数字
            for (int k = 0; k < n; k++) {
                char c = board[i][k];
                if (k != j && c != '.') {
                    nums[c - '0'] = '.';
                }
            }

            // 排除列的数字
            for (int k = 0; k < n; k++) {
                char c = board[k][j];
                if (k != i && c != '.') {
                    nums[c - '0'] = '.';
                }
            }

            // 排除九宫格的数字
            int l_start = i / 3;
            int c_start = j / 3;
            for (int p = l_start; p < l_start + 3; p++) {
                for (int q = c_start; q < c_start + 3; q++) {
                    char c = board[p][q];
                    if (p != i && q != j && c != '.') {
                        nums[c - '0'] = '.';
                    }
                }
            }

            int count = 0;
            for (int k = 0; k < nums.length; k++) {
                if (nums[k] != '.') {
                    count++;
                }
            }

            char[] result = new char[count];
            int p = 0;
            for (int k = 0; k < nums.length; k++) {
                if (nums[k] != '.') {
                    result[p++] = nums[k];
                }
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}