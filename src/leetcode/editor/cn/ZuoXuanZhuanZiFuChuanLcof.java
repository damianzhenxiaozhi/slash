//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数
//将返回左旋转两位得到的结果"cdefgab"。 
//
// 
//
// 示例 1： 
//
// 输入: s = "abcdefg", k = 2
//输出: "cdefgab"
// 
//
// 示例 2： 
//
// 输入: s = "lrloseumgh", k = 6
//输出: "umghlrlose"
// 
//
// 
//
// 限制： 
//
// 
// 1 <= k < s.length <= 10000 
// 
// Related Topics 字符串 
// 👍 118 👎 0


package leetcode.editor.cn;

public class ZuoXuanZhuanZiFuChuanLcof {
    public static void main(String[] args) {
        Solution s = new ZuoXuanZhuanZiFuChuanLcof().new Solution();
        String input = "lrloseumgh";
        int n = 6;
        System.out.println(s.reverseLeftWords(input, n));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseLeftWords(String s, int n) {
            int N = s.length();
            if (n < 0 || n >= N) {
                return s;
            }

            char[] result = new char[N];

            int k = 0;
            // n..N-1
            for (int i = n; i < N; i++) {
                result[k++] = s.charAt(i);
            }

            // 0..n-1
            for (int i = 0; i < n; i++) {
                result[k++] = s.charAt(i);
            }

            return new String(result);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}