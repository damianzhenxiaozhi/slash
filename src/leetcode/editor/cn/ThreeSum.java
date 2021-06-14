//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3413 👎 0


package leetcode.editor.cn;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        Solution s = new ThreeSum().new Solution();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = s.threeSum(nums);
        System.out.println(result.toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();

            int n = nums.length;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(nums[i], i);
            }

            for (int i = 0; i < n; i++) {
                if (i != 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                for (int j = i + 1; j < n; j++) {
                    if (j != i + 1 && nums[j] == nums[j-1]) {
                        continue;
                    }

                    if (map.containsKey(-nums[i] - nums[j])) {
                        int k = map.get(-nums[i] - nums[j]);
                        if (k > j) {
                            List<Integer> tmp = new ArrayList<>();
                            tmp.add(nums[i]);
                            tmp.add(nums[j]);
                            tmp.add(nums[k]);
                            result.add(tmp);
                        }
                    }
                }
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}