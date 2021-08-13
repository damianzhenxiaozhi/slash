//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 1169 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        Solution s = new MoveZeroes().new Solution();
        int[] nums = {1, 0};
        s.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int n = nums.length;
            if (n <= 1) {
                return;
            }

            int i = 0, j = 0;
            while (j < n) {
                if (nums[j] != 0) {
                    swap(nums, i, j);
                    i++;
                    j++;
                } else {
                    j++;
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
