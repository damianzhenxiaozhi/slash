//给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差 
//
// 
//
// 示例： 
//
// 
//输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
//输出：3，即数值对(11, 8)
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length, b.length <= 100000 
// -2147483648 <= a[i], b[i] <= 2147483647 
// 正确结果在区间 [0, 2147483647] 内 
// 
// Related Topics 数组 双指针 二分查找 排序 
// 👍 38 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class SmallestDifferenceLcci {
    public static void main(String[] args) {
        Solution s = new SmallestDifferenceLcci().new Solution();
        int[] a = {1, 3, 15, 11, 2};
        int[] b = {23, 127, 235, 19, 8};
        System.out.println(s.smallestDifference(a, b));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int smallestDifference(int[] a, int[] b) {
            Arrays.sort(a);
            Arrays.sort(b);

            int i = 0, j = 0;
            long min = Integer.MAX_VALUE;
            while (i < a.length && j < b.length) {
                long diff = a[i] - b[j];
                if (diff == 0) {
                    return 0;
                } else if (diff < 0) {
                    i++;
                } else {
                    j++;
                }
                min = Math.min(min, Math.abs(diff));
            }

            return (int) min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
