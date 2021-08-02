//配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。 
//
// 示例1: 
//
// 
// 输入：num = 2（或者0b10）
// 输出 1 (或者 0b01)
// 
//
// 示例2: 
//
// 
// 输入：num = 3
// 输出：3
// 
//
// 提示: 
//
// 
// num的范围在[0, 2^30 - 1]之间，不会发生整数溢出。 
// 
// Related Topics 位运算 
// 👍 46 👎 0


package leetcode.editor.cn;

public class ExchangeLcci {
    public static void main(String[] args) {
        Solution s = new ExchangeLcci().new Solution();
        int num = 2;
        System.out.println(s.exchangeBits(num));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int exchangeBits(int num) {
            int[] bits = new int[32];
            for (int i = 31; i >= 0; i--) {
                bits[i] = (num & 1);
                num >>= 1;
            }

            for (int i = 0; i < 32 / 2; i++) {
                int tmp = bits[2 * i];
                bits[2 * i] = bits[2 * i + 1];
                bits[2 * i + 1] = tmp;
            }

            int result = 0;
            for (int i = 0; i < 32; i++) {
                result <<= 1;
                result += bits[i];
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}