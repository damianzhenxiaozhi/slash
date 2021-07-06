//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。 
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯 
// 👍 318 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIii {
    public static void main(String[] args) {
        Solution s = new CombinationSumIii().new Solution();
        int k = 3;
        int n = 9;
        System.out.println(s.combinationSum3(k, n));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combinationSum3(int k, int n) {
            int[] nums = new int[9];
            for (int i = 0; i < 9; i++) {
                nums[i] = i + 1;
            }

            backtrace(nums, k, n, 0, 0, 0, new ArrayList<>());

            return result;
        }

        private void backtrace(int[] nums, int k, int n, int i, int count, int sum, List<Integer> path) {
            if (i == nums.length || count == k) {
                if (count == k && sum == n) {
                    result.add(new ArrayList<>(path));
                }
                return;
            }

            path.add(nums[i]);
            backtrace(nums, k, n, i + 1, count + 1, sum + nums[i], path);
            path.remove(path.size() - 1);

            backtrace(nums, k, n, i + 1, count, sum, path);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
