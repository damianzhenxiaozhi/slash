//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯 
// 👍 1415 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        Solution s = new CombinationSum().new Solution();
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        System.out.println(s.combinationSum(candidates, target));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            backtrace(candidates, 0, 0, target, new ArrayList<>());

            return result;
        }

        private void backtrace(int[] candidates, int sum, int k, int target, List<Integer> path) {
            if (k == candidates.length || sum == target) {
                if (sum == target) {
                    result.add(new ArrayList<>(path));
                }
                return;
            }

            int count = (target - sum) / candidates[k];
            for (int i = 0; i <= count; i++) {
                for (int j = 0; j < i; j++) {
                    path.add(candidates[k]);
                    sum += candidates[k];
                }

                backtrace(candidates, sum, k + 1, target, path);

                for (int j = 0; j < i; j++) {
                    path.remove(path.size() - 1);
                    sum -= candidates[k];
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
