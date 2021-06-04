//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xn <= 104 
// 
//
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归 
// 👍 158 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ShuZhiDeZhengShuCiFangLcof {
    public static void main(String[] args) {
        Solution s = new ShuZhiDeZhengShuCiFangLcof().new Solution();
        System.out.println(s.myPow(2, -2147483648));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            if (n < 0) {
                return 1/posPow(x, -n);
            } else {
                return posPow(x, n);
            }
        }

        private double posPow(double x, int n) {
            if (n == 0) {
                return 1;
            }

            double tmp = posPow(x, n/2);
            if (n % 2 == 0) {
                return tmp * tmp;
            } else {
                return tmp * tmp * x;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
