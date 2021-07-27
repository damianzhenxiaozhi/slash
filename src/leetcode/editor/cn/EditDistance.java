//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 1721 👎 0


public class EditDistance {
    public static void main(String[] args) {
        Solution s = new EditDistance().new Solution();
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(s.minDistance(word1, word2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            char[] cw1 = word1.toCharArray();
            char[] cw2 = word2.toCharArray();

            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                dp[i][0] = dp[i - 1][0] + 1;
            }
            for (int i = 1; i <= n; i++) {
                dp[0][i] = dp[0][i - 1] + 1;
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (cw1[i - 1] == cw2[j - 1]) {
                        dp[i][j] = min3(dp[i - 1][j - 1], dp[i][j - 1] + 1, dp[i - 1][j] + 1);
                    } else {
                        dp[i][j] = min3(dp[i][j - 1] + 1, dp[i - 1][j] + 1, dp[i-1][j-1] + 1);
                    }
                }
            }

            return dp[m][n];
        }

        private int min3(int a, int b, int c) {
            int min = a;
            if (b < min) {
                min = b;
            }
            if (c < min) {
                min = c;
            }

            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
