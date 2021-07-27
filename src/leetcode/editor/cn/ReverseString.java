//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。 
//
// 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。 
//
// 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。 
//
// 
//
// 示例 1： 
//
// 输入：["h","e","l","l","o"]
//输出：["o","l","l","e","h"]
// 
//
// 示例 2： 
//
// 输入：["H","a","n","n","a","h"]
//输出：["h","a","n","n","a","H"] 
// Related Topics 双指针 字符串 
// 👍 406 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        Solution s = new ReverseString().new Solution();
        char[] input = new char[]{'h', 'e', 'l', 'l', 'o'};
        s.reverseString(input);
        System.out.println(Arrays.toString(input));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {
            int i = 0, j = s.length - 1;
            while (i < j) {
                char tmp = s[i];
                s[i] = s[j];
                s[j] = tmp;
                i++;
                j--;
            }
        }

        public void reverseString2(char[] s) {
            int N = s.length;
            // 0..N/2-1
            for (int i = 0; i < N / 2; i++) {
                char tmp = s[i];
                s[i] = s[N - 1 - i];
                s[N - 1 - i] = tmp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}