//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。 
//
// 
//
// 示例 1： 
//
// 输入：
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出：
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2： 
//
// 输入：
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出：
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
// 
// Related Topics 数组 
// 👍 30 👎 0


package leetcode.editor.cn;

public class ZeroMatrixLcci {
    public static void main(String[] args) {
        Solution s = new ZeroMatrixLcci().new Solution();
        int[][] matrix = new int[][]{{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
        s.setZeroes(matrix);

        print(matrix);
    }

    private static void print(int[][] matrix) {
        int M = matrix.length;
        if (M == 0) {
            System.out.printf("[]");
            return;
        }
        int N = matrix[0].length;

        for (int i = 0; i < M; i++) {
            System.out.printf("[");
            for (int j = 0; j < N; j++) {
                System.out.printf(String.valueOf(matrix[i][j]));
                if (j != N - 1) {
                    System.out.printf(", ");
                }
            }
            if (i != M -1) {
                System.out.println("],");
            } else {
                System.out.println("]");
            }
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            int M = matrix.length;
            if (M == 0) {
                return;
            }
            int N = matrix[0].length;

            int[] zeroLine = new int[M*N];
            int zl = 0;
            int[] zeroCol = new int[M*N];
            int zc = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (matrix[i][j] == 0) {
                        zeroLine[zl++] = i;
                        zeroCol[zc++] = j;
                    }
                }
            }

            for (int i = 0; i < zl; i++) {
                int line = zeroLine[i];
                for (int j = 0; j < N; j++) {
                    matrix[line][j] = 0;
                }
            }

            for (int i = 0; i < zc; i++) {
                int col = zeroCol[i];
                for (int j = 0; j < M; j++) {
                    matrix[j][col] = 0;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}