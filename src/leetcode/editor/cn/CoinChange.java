//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 广度优先搜索 数组 动态规划 
// 👍 1367 👎 0


package leetcode.editor.cn;

public class CoinChange {
    public static void main(String[] args) {
        Solution s = new CoinChange().new Solution();
        int[] coins = {1};
        int amount = 0;
        System.out.println(s.coinChange(coins, amount));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int n = coins.length;
            int[][] dp = new int[n][amount + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < amount + 1; j++) {
                    dp[i][j] = -1;
                }
            }

            for (int i = 0; i <= amount / coins[0]; i++) {
                dp[0][coins[0] * i] = i;
            }

            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= amount; j++) {
                    int min = Integer.MAX_VALUE;
                    int k = 0;
                    while (j - coins[i] * k >= 0) {
                        if (dp[i - 1][j - coins[i] * k] != -1) {
                            min = Math.min(min, (k + dp[i - 1][j - coins[i] * k]));
                        }
                        k++;
                    }
                    if (min != Integer.MAX_VALUE) {
                        dp[i][j] = min;
                    }
                }
            }

            int result = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {
                if (dp[i][amount] != -1) {
                    result = Math.min(dp[i][amount], result);
                }
            }

            return result == Integer.MAX_VALUE ? -1 : result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
