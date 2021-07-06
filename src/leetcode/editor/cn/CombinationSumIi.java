//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯 
// 👍 619 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationSumIi {
    public static void main(String[] args) {
        Solution s = new CombinationSumIi().new Solution();
        int[] candidates = new int[] {2,5,2,1,2};
        int target = 5;
        System.out.println(s.combinationSum2(candidates, target));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Map<Integer, Integer> hm = new HashMap<>();
            for (int num : candidates) {
                hm.put(num, hm.getOrDefault(num, 0) + 1);
            }

            int[] uniqueNums = new int[hm.size()];
            int[] counts = new int[hm.size()];

            int i = 0;
            for (int num : candidates) {
                if (hm.containsKey(num)) {
                    uniqueNums[i] = num;
                    counts[i] = hm.get(num);
                    i++;
                    hm.remove(num);
                }
            }

            backtrace(uniqueNums, counts, 0, 0, target, new ArrayList<>());

            return result;
        }

        private void backtrace(int[] uniqueNums, int[] counts, int k, int sum, int target, List<Integer> path) {
            if (k == uniqueNums.length || sum == target) {
                if (sum == target) {
                    result.add(new ArrayList<>(path));
                }
                return;
            }

            for (int count = 0; count <= counts[k]; count++) {
                if (sum + uniqueNums[k] * count > target) {
                    continue;
                }

                for (int i = 0; i < count; i++) {
                    path.add(uniqueNums[k]);
                }

                backtrace(uniqueNums, counts, k + 1, sum + uniqueNums[k] * count, target, path);

                for (int i = 0; i < count; i++) {
                    path.remove(path.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
