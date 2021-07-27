//设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。 
//
// 示例 1: 
//
// 输入: nums = [5,6,5], target = 11
//输出: [[5,6]] 
//
// 示例 2: 
//
// 输入: nums = [5,6,5,6], target = 11
//输出: [[5,6],[5,6]] 
//
// 提示： 
//
// 
// nums.length <= 100000 
// 
// Related Topics 数组 哈希表 双指针 计数 排序 
// 👍 28 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairsWithSumLcci {
    public static void main(String[] args) {
        Solution s = new PairsWithSumLcci().new Solution();
        int[] nums = {5, 5, 6, 6};
        int target = 11;
        System.out.println(s.pairSums(nums, target));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> pairSums(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            int i = 0, j = nums.length-1;
            while (i < j) {
                if (nums[i] + nums[j] == target) {
                    result.add(Arrays.asList(nums[i], nums[j]));
                    i++;
                    j--;
                } else if (nums[i] + nums[j] < target) {
                    i++;
                } else {
                    j--;
                }
            }

            return result;
        }

        public List<List<Integer>> pairSumsExceedTime(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();

            int N = nums.length;
            boolean[] used = new boolean[N];
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (!used[i] && !used[j]) {
                        if (nums[i] + nums[j] == target) {
                            result.add(Arrays.asList(nums[i], nums[j]));
                            used[i] = true;
                            used[j] = true;
                            break;
                        }
                    }
                }
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
