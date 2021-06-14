//给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。 
//
// 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
// 
//
// 示例: 
//
// 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
//输出: [1, 3]
// 
//
// 示例: 
//
// 输入: array1 = [1, 2, 3], array2 = [4, 5, 6]
//输出: [] 
//
// 提示： 
//
// 
// 1 <= array1.length, array2.length <= 100000 
// 
// Related Topics 排序 数组 
// 👍 25 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;

public class SumSwapLcci {
    public static void main(String[] args) {
        Solution s = new SumSwapLcci().new Solution();
        int[] array1 = new int[]{4, 1, 2, 1, 1, 2};
        int[] array2 = new int[]{3, 6, 3, 3};
        System.out.println(Arrays.toString(s.findSwapValues(array1, array2)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findSwapValues(int[] array1, int[] array2) {
            int sum1 = 0;
            for (int i = 0; i < array1.length; i++) {
                sum1 += array1[i];
            }

            int sum2 = 0;
            HashSet<Integer> ht = new HashSet<>();
            for (int i = 0; i < array2.length; i++) {
                sum2 += array2[i];
                ht.add(array2[i]);
            }

            if ((sum1 + sum2) % 2 != 0) {
                return new int[0];
            }

            int avg = (sum1 + sum2) / 2;
            int diff = sum1 - avg;
            for (int i = 0; i < array1.length; i++) {
                int target = array1[i] - diff;
                if (ht.contains(target)) {
                    return new int[]{array1[i], target};
                }
            }

            return new int[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}