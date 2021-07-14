//给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
// Related Topics 数组 动态规划 回溯 
// 👍 828 👎 0


package leetcode.editor.cn;

public class TargetSum {
    public static void main(String[] args) {
        Solution s = new TargetSum().new Solution();
        int[] nums = {0,0,0,0,0,0,0,0,1};
        int target = 1;
        System.out.println(s.findTargetSumWays(nums, target));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += Math.abs(nums[i]);
            }

            int stateCount = 2 * sum + 1;
            int[][] dp = new int[nums.length][stateCount];

            dp[0][-nums[0] + sum] += 1;
            dp[0][nums[0] + sum] += 1;

            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < stateCount; j++) {
                    if (j - nums[i] >= 0 && dp[i - 1][j - nums[i]] != 0) {
                        dp[i][j] += dp[i - 1][j - nums[i]];
                    }
                    if (j + nums[i] < stateCount && dp[i - 1][j + nums[i]] != 0) {
                        dp[i][j] += dp[i - 1][j + nums[i]];
                    }
                }
            }

            if (target + sum >= stateCount) {
                return 0;
            }

            return dp[nums.length - 1][target + sum];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
