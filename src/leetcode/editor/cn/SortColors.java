//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[0]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以不使用代码库中的排序函数来解决这道题吗？ 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针 
// 👍 909 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        Solution s = new SortColors().new Solution();
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // tow points
        public void sortColors(int[] nums) {
            int p0 = 0, p1 = 0, p2 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    swap(nums, p0, i);
                    swap(nums, p1, i);
                    p0++;
                    p1++;
                    p2++;
                } else if (nums[i] == 1) {
                    swap(nums, p1, i);
                    p1++;
                    p2++;
                } else if (nums[i] == 2) {
                    swap(nums, p2, i);
                    p2++;
                }
            }
        }

        // partition
        public void sortColors2(int[] nums) {
            int n = nums.length;

            int r = partition(nums, 0, n - 1, 1);

            partition(nums, 0, r, 0);
        }


        private int partition(int[] nums, int p, int q, int pivot) {
            int i = p;
            while (i < q) {
                if (nums[i] == pivot) {
                    break;
                }
                i++;
            }
            swap(nums, i, q);

            i = p;
            for (int j = p; j <= q - 1; j++) {
                if (nums[j] <= pivot) {
                    swap(nums, i, j);
                    i++;
                }
            }

            swap(nums, i, q);

            return i;
        }

        private void swap(int[] nums, int a, int b) {
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
