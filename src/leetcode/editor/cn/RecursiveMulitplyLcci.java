//递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。 
//
// 示例1: 
//
// 
// 输入：A = 1, B = 10
// 输出：10
// 
//
// 示例2: 
//
// 
// 输入：A = 3, B = 4
// 输出：12
// 
//
// 提示: 
//
// 
// 保证乘法范围不会溢出 
// 
// Related Topics 递归 
// 👍 43 👎 0


package leetcode.editor.cn;

public class RecursiveMulitplyLcci {
    public static void main(String[] args) {
        Solution s = new RecursiveMulitplyLcci().new Solution();
        System.out.println(s.multiply(8, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int multiply(int A, int B) {
            int min = A;
            int max = B;
            if (A > B) {
                min = B;
                max = A;
            }

            if (max == 0) {
                return 0;
            }

            if (max == 1) {
                return A;
            }

            int tmp = multiply(min, max / 2);
            if (max % 2 == 0) {
                return tmp + tmp;
            } else {
                return tmp + tmp + min;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
