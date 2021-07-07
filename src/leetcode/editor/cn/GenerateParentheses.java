//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 1865 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution s = new GenerateParentheses().new Solution();
        int n = 3;
        System.out.println(s.generateParenthesis(n));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<String> result = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            backtrace(n, n, n, 0, new ArrayList<>());
            return result;
        }

        private void backtrace(int n, int left, int right, int leftCount, List<String> path) {
            if (left == 0 && right == 0) {
                result.add(path.stream().collect(Collectors.joining()));
                return;
            }

            if (left > 0) {
                path.add("(");
                backtrace(n, left - 1, right, leftCount + 1, path);
                path.remove(path.size() - 1);
            }

            if (right > 0 && leftCount > n - right) {
                path.add(")");
                backtrace(n, left, right - 1, leftCount, path);
                path.remove(path.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
