//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 
// 👍 739 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationsIi {
    public static void main(String[] args) {
        Solution s = new PermutationsIi().new Solution();
        int[] nums = new int[]{1, 1, 2};
        System.out.println(s.permuteUnique(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> permuteUnique(int[] nums) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
            }

            int[] distincts = new int[countMap.size()];
            int[] counts = new int[countMap.size()];

            int i = 0;
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                distincts[i] = entry.getKey();
                counts[i] = entry.getValue();
                i++;
            }

            backtrace(distincts, counts, 0, nums.length, new ArrayList<>());

            return result;
        }

        private void backtrace(int[] nums, int[] counts, int k, int n, List<Integer> path) {
            if (k >= n) {
                List<Integer> snapshot = new ArrayList<>(path);
                result.add(snapshot);
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (counts[i] > 0) {
                    path.add(nums[i]);
                    counts[i]--;
                    backtrace(nums, counts, k + 1, n, path);
                    path.remove(path.size() - 1);
                    counts[i]++;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
