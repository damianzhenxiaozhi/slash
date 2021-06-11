//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
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
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 443 👎 0


package leetcode.editor.cn;

public class SearchA2dMatrix {
    public static void main(String[] args) {
        Solution s = new SearchA2dMatrix().new Solution();
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        System.out.println(s.searchMatrix(matrix, target));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;

            int low = 0, high = m * n - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int i = mid / n;
                int j = mid % n;

                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
