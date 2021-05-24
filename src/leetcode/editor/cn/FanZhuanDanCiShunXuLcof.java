//输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
//则输出"student. a am I"。 
//
// 
//
// 示例 1： 
//
// 输入: "the sky is blue"
//输出: "blue is sky the"
// 
//
// 示例 2： 
//
// 输入: "  hello world!  "
//输出: "world! hello"
//解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 
//
// 示例 3： 
//
// 输入: "a good   example"
//输出: "example good a"
//解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
// 
//
// 
//
// 说明： 
//
// 
// 无空格字符构成一个单词。 
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。 
// 
//
// 注意：本题与主站 151 题相同：https://leetcode-cn.com/problems/reverse-words-in-a-string/ 
//
//
// 注意：此题对比原题有改动 
// Related Topics 字符串 
// 👍 98 👎 0


package leetcode.editor.cn;

public class FanZhuanDanCiShunXuLcof {
  public static void main(String[] args) {
    Solution s = new FanZhuanDanCiShunXuLcof().new Solution();
    String input = "the sky is blue";
    System.out.println(s.reverseWords(input));
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        int N = s.length();
        if (N == 0) {
            return "";
        }

        char[] result = new char[N];
        int wStart = -1;
        int wEnd = -1;
        int ri = 0;

        boolean inWord = false;
        for (int i = N-1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (!inWord) {
                    continue;
                } else {
                    inWord = false;
                    reverse(result, wStart, wEnd);
                    result[ri++] = ' ';
                }
            } else {
                if (!inWord) {
                    inWord = true;
                    wStart = ri;
                    wEnd = ri;
                    result[ri++] = c;
                } else {
                    wEnd = ri;
                    result[ri++] = c;
                }
            }
        }

        // last in word
        if (inWord) {
            reverse(result, wStart, wEnd);
        }

        // no words found
        if (wEnd == -1) {
            return "";
        }

        char[] trimTail = new char[wEnd + 1];
        for (int i = 0; i <= wEnd; i++) {
            trimTail[i] = result[i];
        }

        return new String(trimTail);
    }

    private void reverse(char[] arr, int i, int j) {
        for (int k = 0; k < (j - i + 1) / 2; k++) {
            char tmp = arr[i+k];
            arr[i+k] = arr[j-k];
            arr[j-k] = tmp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}