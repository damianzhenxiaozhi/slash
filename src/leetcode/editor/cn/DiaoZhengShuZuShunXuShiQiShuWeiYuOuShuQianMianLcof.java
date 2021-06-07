//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。 
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// 👍 127 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {
    public static void main(String[] args) {
        Solution s = new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
        int[] nums = new int[]{2, 16, 3, 5, 13, 1, 16, 1, 12, 18, 11, 8, 11, 11, 5, 1};
        int[] result = s.exchange(nums);
        System.out.println(Arrays.toString(result));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] exchange(int[] nums) {
            int n = nums.length;

            mergeSort(nums, 0, n - 1);

            return nums;
        }

        private void mergeSort(int[] nums, int p, int q) {
            if (p >= q) {
                return;
            }

            int r = p + (q - p) / 2;
            mergeSort(nums, p, r);
            mergeSort(nums, r + 1, q);

            merge(nums, p, r, q);
        }

        private void merge(int[] nums, int p, int r, int q) {
            int[] tmp = new int[q - p + 1];
            int i = p, j = r + 1, k = 0;
            while (i <= r && j <= q) {
                if (nums[i] % 2 >= nums[j] % 2) {
                    tmp[k++] = nums[i++];
                } else {
                    tmp[k++] = nums[j++];
                }
            }

            while (i <= r) {
                tmp[k++] = nums[i++];
            }

            while (j <= q) {
                tmp[k++] = nums[j++];
            }

            for (k = 0; k < q - p + 1; k++) {
                nums[p + k] = tmp[k];
            }
        }

        public int[] exchange1(int[] nums) {
            int n = nums.length;
            int[] tmp = new int[n];

            int k = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] % 2 != 0) {
                    tmp[k++] = nums[i];
                }
            }

            for (int i = 0; i < n; i++) {
                if (nums[i] % 2 == 0) {
                    tmp[k++] = nums[i];
                }
            }

            return tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
