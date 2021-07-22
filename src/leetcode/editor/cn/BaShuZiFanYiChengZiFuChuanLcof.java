//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 231 
// 
// Related Topics 字符串 动态规划 
// 👍 253 👎 0


package leetcode.editor.cn;

public class BaShuZiFanYiChengZiFuChuanLcof {
    public static void main(String[] args) {
        Solution s = new BaShuZiFanYiChengZiFuChuanLcof().new Solution();
        int num = 506;
        System.out.println(s.translateNum(num));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int translateNum(int num) {
            String s = String.valueOf(num);
            int n = s.length();

            int[] dp = new int[n + 1];
            dp[1] = 1;

            for (int i = 2; i <= n; i++) {
                int sum = 0;

                if (isValid(s.substring(0, i))) {
                    sum = 1;
                }
                for (int j = 1; j < i; j++) {
                    if (isValid(s.substring(j, i))) {
                        sum += dp[j];
                    }
                }
                dp[i] = sum;
            }

            return dp[n];
        }

        private boolean isValid(String s) {
            if (s.length() > 1 && s.charAt(0) == '0') {
                return false;
            }

            return Integer.parseInt(s) <= 25;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
