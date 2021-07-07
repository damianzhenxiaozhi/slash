//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 768 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        Solution s = new PalindromePartitioning().new Solution();
        String str = "aab";
        System.out.println(s.partition(str));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<String>> result = new ArrayList<>();

        public List<List<String>> partition(String s) {
            char[] chars = s.toCharArray();
            backtrace(chars, 0, new ArrayList<>());
            return result;
        }

        private void backtrace(char[] chars, int k, List<String> path) {
            if (k == chars.length) {
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = k; i < chars.length; i++) {
                if (isPalindrome(chars, k, i)) {
                    path.add(new String(chars, k, i - k + 1));
                    backtrace(chars, i + 1, path);
                    path.remove(path.size() - 1);
                }
            }
        }

        private boolean isPalindrome(char[] chars, int i, int j) {
            while (i < j) {
                if (chars[i] != chars[j]) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
