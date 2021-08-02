//整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。 
//
// 示例1: 
//
// 
// 输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
// 输出：2
// 
//
// 示例2: 
//
// 
// 输入：A = 1，B = 2
// 输出：2
// 
//
// 提示: 
//
// 
// A，B范围在[-2147483648, 2147483647]之间 
// 
// Related Topics 位运算 
// 👍 29 👎 0


package leetcode.editor.cn;

public class ConvertIntegerLcci {
    public static void main(String[] args) {
        Solution s = new ConvertIntegerLcci().new Solution();
        int A = 3;
        int B = 1;
        System.out.println(s.convertInteger(A, B));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int convertInteger(int A, int B) {
            int z = A ^ B;
            int count = 0;
            int mask = 1;
            for (int i = 0; i < 32; i++) {
                if ((z & mask) != 0) {
                    count++;
                }

                mask <<= 1;
            }

            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}