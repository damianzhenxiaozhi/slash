//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 
// 👍 1428 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution s = new Permutations().new Solution();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(s.permute(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            if (nums == null || nums.length == 0) {
                return Collections.emptyList();
            }

            int n = nums.length;
            boolean[] used = new boolean[n];

            backtrace(nums, n, used, 0, new ArrayList());

            return result;
        }

        private void backtrace(int[] nums, int n, boolean[] used, int k, List<Integer> path) {
            if (k >= n) {
                List<Integer> snapshot = new ArrayList<>(path);
                result.add(snapshot);
                return;
            }

            for (int i = 0; i < n; i++) {
                if (used[i]) {
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;
                backtrace(nums, n, used, k + 1, path);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
