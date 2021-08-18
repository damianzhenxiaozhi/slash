//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,3,3]
//输出：4
// 
//
// 示例 2： 
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10000 
// 1 <= nums[i] < 2^31 
// 
//
// 
// Related Topics 位运算 数组 
// 👍 218 👎 0


package leetcode.editor.cn;

public class ShuZuZhongShuZiChuXianDeCiShuIiLcof {
    public static void main(String[] args) {
        Solution s = new ShuZuZhongShuZiChuXianDeCiShuIiLcof().new Solution();
        int[] nums = {9, 1, 7, 9, 7, 9, 7};
        System.out.println(s.singleNumber(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int[] bitCount = new int[32];
            int mask = 1;
            for (int i = 0; i < 32; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if ((nums[j] & mask) != 0) {
                        bitCount[i] = (bitCount[i] + 1) % 3;
                    }
                }
                mask <<= 1;
            }

            int result = 0;
            int p = 1;
            for (int i = 0; i < 32; i++) {
                if (bitCount[i] != 0) {
                    result += p;
                }
                p <<= 1;
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
