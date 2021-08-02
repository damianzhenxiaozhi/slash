//给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。 
//
// 示例 1： 
//
// 输入: num = 1775(110111011112)
//输出: 8
// 
//
// 示例 2： 
//
// 输入: num = 7(01112)
//输出: 4
// 
// Related Topics 位运算 动态规划 
// 👍 44 👎 0


package leetcode.editor.cn;

public class ReverseBitsLcci {
    public static void main(String[] args) {
        Solution s = new ReverseBitsLcci().new Solution();
        int num = -2;
        System.out.println(s.reverseBits(num));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverseBits(int num) {
            int[] bits = new int[32];
            for (int i = 31; i >= 0; i--) {
                bits[i] = num & 1;
                num >>= 1;
                if (num == 0) {
                    break;
                }
            }

            int[] lengths = new int[32];
            int sum = 0;
            for (int i = 31; i >= 0; i--) {
                if (bits[i] == 1) {
                    sum += 1;
                } else {
                    sum = 0;
                }
                lengths[i] = sum;
            }

            int maxLen = 0;
            for (int i = 0; i < 32; i++) {
                int curLen = lengths[i];
                int j = i + lengths[i];
                if (j < 32) {
                    curLen += 1;
                    if (j + 1 < 32) {
                        curLen += lengths[j + 1];
                    }
                }

                if (curLen > maxLen) {
                    maxLen = curLen;
                }
            }

            return maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}