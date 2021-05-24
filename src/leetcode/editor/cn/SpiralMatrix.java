//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 782 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        Solution s = new SpiralMatrix().new Solution();
        int[][] matrix = new int[][]{{3}, {2}};
        System.out.println(s.spiralOrder(matrix));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int M = matrix.length;
            if (M == 0) {
                return Collections.emptyList();
            }
            int N = matrix[0].length;

            List<Integer> result = new ArrayList<>(matrix.length * matrix.length);

            int x1 = 0, x2 = M - 1, y1 = 0, y2 = N - 1;
            while (x1 <= x2 && y1 <= y2) {
                outputEdge(matrix, x1, x2, y1, y2, result);
                x1++;
                x2--;
                y1++;
                y2--;
            }

            return result;
        }

        private void outputEdge(int[][] matrix, int x1, int x2, int y1, int y2, List<Integer> result) {
            if (x1 == x2) {
                for (int j = y1; j <= y2; j++) {
                    result.add(matrix[x1][j]);
                }
                return;
            }

            if (y1 == y2) {
                for (int i = x1; i <= x2; i++) {
                    result.add(matrix[i][y1]);
                }
                return;
            }

            for (int j = y1; j <= y2; j++) {
                result.add(matrix[x1][j]);
            }

            for (int i = x1 + 1; i <= x2; i++) {
                result.add(matrix[i][y2]);
            }

            for (int j = y2 - 1; j >= y1; j--) {
                result.add(matrix[x2][j]);
            }

            for (int i = x2 - 1; i >= x1 + 1; i--) {
                result.add(matrix[i][y1]);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}