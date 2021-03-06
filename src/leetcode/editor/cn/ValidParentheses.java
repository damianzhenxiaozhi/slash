//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2427 👎 0


package leetcode.editor.cn;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution s = new ValidParentheses().new Solution();
        System.out.println(s.isValid("()[]{}"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

            for (char c : s.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    char peek = stack.peek();
                    if (match(peek, c)) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }

            return stack.isEmpty();
        }

        private boolean match(char a, char b) {
            if (a == '(' && b == ')') {
                return true;
            }

            if (a == '[' && b == ']') {
                return true;
            }

            if (a == '{' && b == '}') {
                return true;
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}