//数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？ 
//
// 注意：本题相对书上原题稍作改动 
//
// 示例 1： 
//
// 输入：[3,0,1]
//输出：2 
//
// 
//
// 示例 2： 
//
// 输入：[9,6,4,2,3,5,7,0,1]
//输出：8
// 
// Related Topics 位运算 数组 哈希表 数学 排序 
// 👍 45 👎 0


package leetcode.editor.cn;

public class MissingNumberLcci {
    public static void main(String[] args) {
        Solution s = new MissingNumberLcci().new Solution();
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(s.missingNumber(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int missingNumber(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }

            int n = nums.length + 1;
            byte[] map = new byte[(n - 1) / 8 + 1];
            for (int i = 0; i < nums.length; i++) {
                int posInt = nums[i] / 8;
                int posBit = nums[i] % 8;
                int mask = 1;
                while (posBit-- > 0) {
                    mask <<= 1;
                }
                map[posInt] |= mask;
            }

            for (int i = 0; i < n; i++) {
                int posInt = i / 8;
                int posBit = i % 8;
                int mask = 1;
                while (posBit-- > 0) {
                    mask <<= 1;
                }
                if ((map[posInt] & mask) == 0) {
                    return i;
                }
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}