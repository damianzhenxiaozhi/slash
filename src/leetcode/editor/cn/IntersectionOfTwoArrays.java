//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 376 👎 0


package leetcode.editor.cn;

import java.util.*;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution s = new IntersectionOfTwoArrays().new Solution();
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(s.intersection(nums1, nums2)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> ht = new HashSet<>();
            for (int i = 0; i < nums1.length; i++) {
                ht.add(nums1[i]);
            }

            Set<Integer> result = new HashSet<>();
            for (int i = 0; i < nums2.length; i++) {
                if (ht.contains(nums2[i])) {
                    result.add(nums2[i]);
                }
            }


            int[] r = new int[result.size()];
            int j = 0;
            for (int i : result) {
                r[j++] = i;
            }
            return r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}