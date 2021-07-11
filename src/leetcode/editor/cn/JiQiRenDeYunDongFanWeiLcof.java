//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// Related Topics 深度优先搜索 广度优先搜索 动态规划 
// 👍 311 👎 0


package leetcode.editor.cn;

public class JiQiRenDeYunDongFanWeiLcof {
    public static void main(String[] args) {
        Solution s = new JiQiRenDeYunDongFanWeiLcof().new Solution();
        int m = 2;
        int n = 3;
        int k = 1;
        System.out.println(s.movingCount(m, n, k));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int count;

        public int movingCount(int m, int n, int k) {
            count = 0;
            moving(0, 0, new boolean[m][n], m, n, k);
            return count;
        }

        private void moving(int i, int j, boolean[][] visited, int m, int n, int k) {
            visited[i][j] = true;
            count++;

            int[][] bound = {{i - 1, j}, {i + 1, j}, {i, j - 1}, {i, j + 1}};

            for (int p = 0; p < 4; p++) {
                int ii = bound[p][0];
                int jj = bound[p][1];
                if (isValid(ii, jj, m, n, k) && !visited[ii][jj]) {
                    moving(bound[p][0], bound[p][1], visited, m, n, k);
                }
            }
        }

        private boolean isValid(int i, int j, int m, int n, int k) {
            if (i < 0 || i >= m) {
                return false;
            }
            if (j < 0 || j >= n) {
                return false;
            }
            int bitSum = bitSum(i)  + bitSum(j);
            if (bitSum > k) {
                return false;
            }
            return true;
        }

        private int bitSum(int n) {
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n = n / 10;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}