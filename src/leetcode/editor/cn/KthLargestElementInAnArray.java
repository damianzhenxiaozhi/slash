//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 1126 👎 0


package leetcode.editor.cn;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution s = new KthLargestElementInAnArray().new Solution();
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(s.findKthLargest(nums, k));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            qsort(nums, 0, nums.length - 1);

            return nums[nums.length - k];
        }

        private void qsort(int[] nums, int p, int q) {
            if (p >= q) {
                return;
            }

            int r = partition(nums, p, q);

            qsort(nums, p, r - 1);
            qsort(nums, r + 1, q);
        }

        private int partition(int[] nums, int p, int q) {
            int pivot = nums[q];

            int i = p;
            for (int j = p; j <= q - 1; j++) {
                if (nums[j] <= pivot) {
                    swap(nums, i, j);
                    i++;
                }
            }

            swap(nums, i, q);
            return i;
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
