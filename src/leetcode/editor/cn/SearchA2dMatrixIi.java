//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性： 
//
// 
// 每行的元素从左到右升序排列。 
// 每列的元素从上到下升序排列。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 5
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 20
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= n, m <= 300 
// -109 <= matix[i][j] <= 109 
// 每行的所有元素从左到右升序排列 
// 每列的所有元素从上到下升序排列 
// -109 <= target <= 109 
// 
// Related Topics 二分查找 分治算法 
// 👍 637 👎 0


package leetcode.editor.cn;

public class SearchA2dMatrixIi {
    public static void main(String[] args) {
        Solution s = new SearchA2dMatrixIi().new Solution();
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 20;
        System.out.println(s.searchMatrix(matrix, target));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int M = matrix.length;
            if (M == 0) {
                return false;
            }
            int N = matrix[0].length;

            return searchMatrix(matrix, M, N, 0, 0, M - 1, N - 1, target);
        }

        private boolean searchMatrix(int[][] matrix, int M, int N, int x1, int y1, int x2, int y2, int target) {
            if (!isValid(M, N, x1, y1)) {
                return false;
            }

            if (!isValid(M, N, x2, y2)) {
                return false;
            }

            if (x2 < x1) {
                return false;
            }

            if (y2 < y1) {
                return false;
            }

            int xMid = x1 + (x2 - x1) / 2;
            int yMid = y1 + (y2 - y1) / 2;
            if (matrix[xMid][yMid] == target) {
                return true;
            }

            if (matrix[xMid][yMid] > target) {
                for (int i = x1; i < xMid; i++) {
                    if (matrix[i][yMid] == target) {
                        return true;
                    }
                }

                for (int j = y1; j < yMid; j++) {
                    if (matrix[xMid][j] == target) {
                        return true;
                    }
                }

                if (searchMatrix(matrix, M, N, x1, y1, xMid - 1, yMid - 1, target)) {
                    return true;
                }

            } else {
                for (int i = xMid + 1; i <= x2; i++) {
                    if (matrix[i][yMid] == target) {
                        return true;
                    }
                }

                for (int j = yMid + 1; j <= y2; j++) {
                    if (matrix[xMid][j] == target) {
                        return true;
                    }
                }

                if (searchMatrix(matrix, M, N, xMid + 1, yMid + 1, x2, y2, target)) {
                    return true;
                }
            }

            if (searchMatrix(matrix, M, N, x1, yMid + 1, xMid - 1, y2, target)) {
                return true;
            }

            if (searchMatrix(matrix, M, N, xMid + 1, y1, x2, yMid - 1, target)) {
                return true;
            }

            return false;
        }

        private boolean isValid(int M, int N, int x, int y) {
            if (x < 0 || x >= M) {
                return false;
            }

            if (y < 0 || y >= N) {
                return false;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}