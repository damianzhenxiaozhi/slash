//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 
// 👍 2531 👎 0


package leetcode.editor.cn;

public class TrappingRainWater {
    public static void main(String[] args) {
        Solution s = new TrappingRainWater().new Solution();
        int[] height = {4, 2, 0, 3, 2, 5};
        System.out.println(s.trap(height));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int n = height.length;
            int[] leftMax = new int[n];
            int max = 0;
            for (int i = 0; i < n; i++) {
                leftMax[i] = max;
                max = Math.max(max, height[i]);
            }

            int[] rightMax = new int[n];
            max = 0;
            for (int i = n-1; i >= 0; i--) {
                rightMax[i] = max;
                max = Math.max(max, height[i]);
            }

            int sum = 0;
            for (int i = 0; i < n; i++) {
                int higher = Math.min(leftMax[i], rightMax[i]);
                if (higher > height[i]) {
                    sum += (higher - height[i]);
                }
            }

            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}