//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
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
// 
// 
// 
// Related Topics 位运算 数组 回溯 
// 👍 602 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubsetsIi {
    public static void main(String[] args) {
        Solution s = new SubsetsIi().new Solution();
        int[] nums = new int[]{1, 2, 2};
        System.out.println(s.subsetsWithDup(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int num : nums) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }

            int n = countMap.size();
            int[] distincts = new int[n];
            int[] counts = new int[n];

            int i = 0;
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                distincts[i] = entry.getKey();
                counts[i] = entry.getValue();
                i = i + 1;
            }

            backtrace(0, distincts, counts, new ArrayList<>());

            return result;
        }

        private void backtrace(int k, int[] nums, int[] counts, List<Integer> path) {
            if (k >= nums.length) {
                List<Integer> snapshot = new ArrayList<>(path);
                result.add(snapshot);
                return;
            }

            for (int count = 0; count <= counts[k]; count++) {
                for (int i = 0; i < count; i++) {
                    path.add(nums[k]);
                }
                backtrace(k+1, nums, counts, path);
                for (int i = 0; i < count; i++) {
                    path.remove(path.size() - 1);
                }

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
