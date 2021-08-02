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
        int[] height = {4, 2, 3};
        System.out.println(s.trap(height));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int sum = 0;
            int n = height.length;
            int i = 0;
            while (i < n) {
                int j = i + 1;
                int curSum = 0;
                while (j < n && height[j] < height[i]) {
                    curSum += (height[i] - height[j]);
                    j++;
                }
                if (j != n) {
                    sum += curSum;
                    i = j;
                } else {
                    i = i + 1;
                }
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}