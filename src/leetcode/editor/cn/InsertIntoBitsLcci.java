//给定两个整型数字 N 与 M，以及表示比特位置的 i 与 j（i <= j，且从 0 位开始计算）。 
//
// 编写一种方法，使 M 对应的二进制数字插入 N 对应的二进制数字的第 i ~ j 位区域，不足之处用 0 补齐。具体插入过程如图所示。 
//
// 
//
// 题目保证从 i 位到 j 位足以容纳 M， 例如： M = 10011，则 i～j 区域至少可容纳 5 位。 
//
// 
//
// 示例1: 
//
// 
// 输入：N = 1024(10000000000), M = 19(10011), i = 2, j = 6
// 输出：N = 1100(10001001100)
// 
//
// 示例2: 
//
// 
// 输入： N = 0, M = 31(11111), i = 0, j = 4
// 输出：N = 31(11111)
// 
// Related Topics 位运算 
// 👍 34 👎 0


package leetcode.editor.cn;

public class InsertIntoBitsLcci {
    public static void main(String[] args) {
        Solution s = new InsertIntoBitsLcci().new Solution();
        int N = 0;
        int M = 31;
        int i = 0;
        int j = 4;
        System.out.println(s.insertBits(N, M, i, j));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int insertBits(int N, int M, int i, int j) {
            int[] nBits = toBits(N);
            int[] mBits = toBits(M);

            for (int k = i; k <= j; k++) {
                nBits[31 - k] = mBits[31 - k + i];
            }

            return toNum(nBits);
        }

        private int[] toBits(int n) {
            int[] bits = new int[32];
            for (int i = 31; i >= 0; i--) {
                bits[i] = n & 1;
                n >>= 1;
                if (n == 0) {
                    break;
                }
            }

            return bits;
        }

        private int toNum(int[] bits) {
            int num = 0;
            for (int i = 0; i < 32; i++) {
                num <<= 1;
                num += bits[i];
            }
            return num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}