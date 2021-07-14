//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 
// 👍 855 👎 0


package leetcode.editor.cn;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution s = new PartitionEqualSubsetSum().new Solution();
        int[] nums = {1, 5, 11, 5};
        System.out.println(s.canPartition(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private boolean found;
        private boolean[][] visited;
        public boolean canPartition(int[] nums) {
            int sum = 0;
            int n = nums.length;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            if (sum % 2 != 0) {
                return false;
            }

            sum = sum / 2;

            // backtrace with note
//            visited = new boolean[n][sum+1];
//            backtrace(nums, 0, 0, sum);
//            return found;

            // dp
            boolean[][] dp = new boolean[n][sum+1];
            dp[0][0] = true;
            if (nums[0] <= sum) {
                dp[0][nums[0]] = true;
            }

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < sum+1; j++) {
                    if (dp[i-1][j]) {
                        dp[i][j] = true;
                    }
                    if (j-nums[i] >= 0 && dp[i-1][j-nums[i]]) {
                        dp[i][j] = true;
                    }
                }
            }

            return dp[n-1][sum];
        }

        private void backtrace(int[] nums, int k, int sum, int target) {
            if (k >= nums.length) {
                return;
            }

            if (found) {
                return;
            }

            if (sum == target) {
                found = true;
                return;
            }

            if (visited[k][sum]) {
                return;
            }
            visited[k][sum] = true;

            backtrace(nums, k+1, sum, target);
            if (sum + nums[k] <= target) {
                backtrace(nums, k+1, sum + nums[k], target);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
