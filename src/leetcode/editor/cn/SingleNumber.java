//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表 
// 👍 1891 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public static void main(String[] args) {
        Solution s = new SingleNumber().new Solution();
        int[] nums = new int[] {4, 1, 2, 1, 2};
        System.out.println(s.singleNumber(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int n = nums.length;

            Map<Integer, Integer> hashTable = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (hashTable.containsKey(nums[i])) {
                    hashTable.put(nums[i], 2);
                } else {
                    hashTable.put(nums[i], 1);
                }
            }

            for (Map.Entry<Integer, Integer> entry : hashTable.entrySet()) {
                if (entry.getValue() == 1) {
                    return entry.getKey();
                }
            }

            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}