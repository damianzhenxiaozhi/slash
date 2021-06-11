//给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。 
//
// 进阶：不要 使用任何内置的库函数，如 sqrt 。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 16
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：num = 14
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 2^31 - 1 
// 
// Related Topics 数学 二分查找 
// 👍 223 👎 0


package leetcode.editor.cn;

public class ValidPerfectSquare {
    public static void main(String[] args) {
        Solution s = new ValidPerfectSquare().new Solution();
        int num = 2147483647;
        System.out.println(s.isPerfectSquare(num));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int num) {
            int low = 1, high = num;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                long s = (long)mid * mid;
                if (s == num) {
                    return true;
                } else if (s < num) {
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
