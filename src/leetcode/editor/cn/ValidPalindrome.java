//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 383 👎 0


package leetcode.editor.cn;

public class ValidPalindrome {
    public static void main(String[] args) {
        Solution s = new ValidPalindrome().new Solution();
        String input = "0P";
        System.out.println(s.isPalindrome(input));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            int N = s.length();
            int head = 0, tail = N - 1;

            while (head <= tail) {
                char cHead = s.charAt(head);
                if (!isAlphaAndDigit(cHead)) {
                    head++;
                    continue;
                }

                char cTail = s.charAt(tail);
                if (!isAlphaAndDigit(cTail)) {
                    tail--;
                    continue;
                }

                if (isEqualIgnoreCamel(cHead, cTail)) {
                    head++;
                    tail--;
                } else {
                    return false;
                }
            }

            return true;
        }

        private boolean isEqualIgnoreCamel(char a, char b) {
            if (a == b) {
                return true;
            }

            if (isAlpha(a) && isAlpha(b)) {
                if (a - 'a' == b - 'A') {
                    return true;
                }

                if (a - 'A' == b - 'a') {
                    return true;
                }
            }

            return false;
        }

        private boolean isAlphaAndDigit(char c) {
            if (c >= '0' && c <= '9') {
                return true;
            }

            if (c >= 'a' && c <= 'z') {
                return true;
            }

            if (c >= 'A' && c <= 'Z') {
                return true;
            }

            return false;
        }

        private boolean isAlpha(char c) {
            if (c >= 'a' && c <= 'z') {
                return true;
            }

            if (c >= 'A' && c <= 'Z') {
                return true;
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}