//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 692 👎 0


package leetcode.editor.cn;

public class Sqrtx {
    public static void main(String[] args) {
        Solution s = new Sqrtx().new Solution();
        int x = 0;
        System.out.println(s.mySqrt(8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            int low = 0, high = x;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                long s = (long)mid * mid;
                long t = ((long)mid + 1) * (mid + 1);
                if (s == x) {
                    return mid;
                } else if (s < x) {
                    if (t > x) {
                        return mid;
                    } else {
                        low = mid + 1;
                    }
                } else {
                    high = mid - 1;
                }
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
