//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 
// 👍 1233 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Solution s = new Subsets().new Solution();
        int[] nums = new int[] {1, 2, 3};
        System.out.println(s.subsets(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            backtrace(nums, 0, new ArrayList<>(2 * nums.length), nums.length);
            return result;
        }

        private void backtrace(int[] nums, int k, List<Integer> path, int n) {
            if (k == n) {
                List<Integer> snapshot = new ArrayList<>(path);
                result.add(snapshot);
                return;
            }

            backtrace(nums, k + 1, path, n);
            path.add(nums[k]);
            backtrace(nums, k + 1, path, n);
            path.remove(path.size() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
