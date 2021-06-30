//设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整
//个棋盘的那两条对角线。 
//
// 注意：本题相对原题做了扩展 
//
// 示例: 
//
//  输入：4
// 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// 解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
// Related Topics 数组 回溯 
// 👍 87 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class EightQueensLcci {
    public static void main(String[] args) {
        Solution s = new EightQueensLcci().new Solution();
        int n = 5;
        List<List<String>> result = s.solveNQueens(n);
        for (List<String> r : result) {
            System.out.println(r.toString());
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<String>> result = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            char[][] chessBoard = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    chessBoard[i][j] = '.';
                }
            }

            backTrace(chessBoard, n, 0);

            return result;
        }

        private void backTrace(char[][] chessBoard, int n, int k) {
            if (k >= n) {
                List<String> path = outputPath(chessBoard, n);
                result.add(path);
                return;
            }

            for (int i = 0; i < n; i++) {
                if (isOk(chessBoard, n, k, i)) {
                    chessBoard[k][i] = 'Q';

                    backTrace(chessBoard, n, k+1);

                    chessBoard[k][i] = '.';
                }
            }
        }

        private boolean isOk(char[][] chessBoard, int n, int i, int j) {
            for (int k = 0; k < i; k++) {
                if (chessBoard[k][j] == 'Q') {
                    return false;
                }
            }

            int p = i - 1;
            int q = j - 1;
            while (p >= 0 && q >= 0) {
                if (chessBoard[p][q] == 'Q') {
                    return false;
                }
                p--;
                q--;
            }

            p = i - 1;
            q = j + 1;
            while (p >= 0 && q < n) {
                if (chessBoard[p][q] == 'Q') {
                    return false;
                }
                p--;
                q++;
            }
            return true;
        }

        private List<String> outputPath(char[][] chessBoard, int n) {
            List<String> path = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(chessBoard[i][j]);
                }
                path.add(sb.toString());
            }

            return path;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}