//两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。 
//
// 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 1, y = 4
//输出：2
//解释：
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//上面的箭头指出了对应二进制位不同的位置。
// 
//
// 示例 2： 
//
// 
//输入：x = 3, y = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x, y <= 231 - 1 
// 
// Related Topics 位运算 
// 👍 500 👎 0


package leetcode.editor.cn;

public class HammingDistance {
    public static void main(String[] args) {
        Solution s = new HammingDistance().new Solution();
        int x = 3;
        int y = 1;
        System.out.println(s.hammingDistance(x, y));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hammingDistance(int x, int y) {
            int z = x ^ y;
            int count = 0;
            for (int i = 0; i < 32; i++) {
                if ((z & 1) != 0) {
                    count++;
                }

                z >>= 1;
                if (z == 0) {
                    break;
                }
            }

            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}