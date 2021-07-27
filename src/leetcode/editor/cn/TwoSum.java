//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 103 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
// Related Topics 数组 哈希表 
// 👍 11152 👎 0


package leetcode.editor.cn;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        Solution s = new TwoSum().new Solution();
        int[] nums = new int[]{2, 5, 3, 8};
        int target = 9;
        int[] result = s.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, List<Integer>> vToIndex = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                vToIndex.computeIfAbsent(nums[i], e -> new ArrayList<>()).add(i);
            }

            Arrays.sort(nums);
            int i = 0, j = nums.length - 1;
            while (i < j) {
                if (nums[i] + nums[j] == target) {
                    if (nums[i] == nums[j]) {
                        return new int[] {vToIndex.get(nums[i]).get(0), vToIndex.get(nums[j]).get(1)};
                    } else {
                        return new int[] {vToIndex.get(nums[i]).get(0), vToIndex.get(nums[j]).get(0)};
                    }
                } else if (nums[i] + nums[j] < target) {
                    i++;
                } else {
                    j--;
                }
            }

            return new int[0];
        }

        public int[] twoSum3(int[] nums, int target) {
            int n = nums.length;

            Map<Integer, Integer> hashTable = new HashMap<>();
            for (int i = 0; i < n; i++) {
                hashTable.put(nums[i], i);
            }

            // 0..N-1
            for (int i = 0; i < n; i++) {
                if (hashTable.containsKey(target - nums[i])) {
                    int pos = hashTable.get(target - nums[i]);
                    if (pos != i) {
                        return new int[]{i, pos};

                    }
                }
            }

            return new int[0];
        }

        public int[] twoSum2(int[] nums, int target) {
            int N = nums.length;
            // 0..N-1
            for (int i = 0; i < N; i++) {
                // i+1..N-1
                for (int j = i + 1; j < N; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }

            return new int[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}