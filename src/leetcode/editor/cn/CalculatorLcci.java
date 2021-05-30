//给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。 
//
// 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。 
//
// 示例 1: 
//
// 输入: "3+2*2"
//输出: 7
// 
//
// 示例 2: 
//
// 输入: " 3/2 "
//输出: 1 
//
// 示例 3: 
//
// 输入: " 3+5 / 2 "
//输出: 5
// 
//
// 说明： 
//
// 
// 你可以假设所给定的表达式都是有效的。 
// 请不要使用内置的库函数 eval。 
// 
// Related Topics 字符串 
// 👍 43 👎 0


package leetcode.editor.cn;

import java.util.Stack;

public class CalculatorLcci {
    public static void main(String[] args) {
        Solution s = new CalculatorLcci().new Solution();
        String input = "42";
        System.out.println(s.calculate(input));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            Stack<Integer> nums = new Stack<>();
            Stack<Character> ops = new Stack<>();

            int n = s.length();
            int i = 0;
            while (i < n) {
                char c = s.charAt(i);
                if (c == ' ') {
                    i++;
                } else if (isDigital(c)) {
                    int num = 0;
                    while (i < n && isDigital(s.charAt(i))) {
                        num = num * 10 + s.charAt(i) - '0';
                        i++;
                    }
                    nums.push(num);
                } else {
                    if (ops.isEmpty() || isPrior(c, ops.peek())) {
                        ops.push(c);
                    } else {
                        while (!ops.isEmpty() && !isPrior(c, ops.peek())) {
                            fetchAndCalc(nums, ops);
                        }
                        ops.push(c);
                    }
                    i++;
                }
            }

            while (!ops.isEmpty()) {
                fetchAndCalc(nums, ops);
            }

            return nums.pop();
        }

        private void fetchAndCalc(Stack<Integer> val, Stack<Character> ops) {
            int val2 = val.pop();
            int val1 = val.pop();
            val.push(calc(val1, val2, ops.pop()));
        }

        private int calc(int val1, int val2, char c) {
            switch (c) {
                case '+':
                    return val1 + val2;
                case '-':
                    return val1 - val2;
                case '*':
                    return val1 * val2;
                case '/':
                    return val1 / val2;
                default:
                    return -1;
            }
        }

        private boolean isPrior(char a, char b) {
            return (a == '*' || a == '/') && (b == '+' || b == '-');
        }

        private boolean isDigital(char c) {
            return c >= '0' && c <= '9';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}