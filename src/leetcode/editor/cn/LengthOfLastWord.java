//给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。 
//
// 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Hello World"
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：s = " "
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅有英文字母和空格 ' ' 组成 
// 
// Related Topics 字符串 
// 👍 314 👎 0


package leetcode.editor.cn;

public class LengthOfLastWord {
    public static void main(String[] args) {
        Solution s = new LengthOfLastWord().new Solution();
        String input = "Hello World";
        System.out.println(s.lengthOfLastWord(input));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLastWord(String s) {
            int len = 0;

            int N = s.length();
            boolean inWord = false;
            for (int i = N - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (c == ' ') {
                    if (inWord) {
                        return len;
                    }
                } else {
                    if (inWord) {
                        len++;
                    } else {
                        inWord = true;
                        len = 1;
                    }
                }
            }

            return len;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}