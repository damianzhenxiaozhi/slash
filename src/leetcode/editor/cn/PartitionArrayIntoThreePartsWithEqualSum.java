//给你一个整数数组 arr，只有可以将其划分为三个和相等的 非空 部分时才返回 true，否则返回 false。 
//
// 形式上，如果可以找出索引 i + 1 < j 且满足 (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + ar
//r[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1]) 
//就可以将数组三等分。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [0,2,1,-6,6,-7,9,1,2,0,1]
//输出：true
//解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
// 
//
// 示例 2： 
//
// 
//输入：arr = [0,2,1,-6,6,7,9,-1,2,0,1]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：arr = [3,3,6,5,-2,2,5,1,-9,4]
//输出：true
//解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
// 
//
// 
//
// 提示： 
//
// 
// 3 <= arr.length <= 5 * 104 
// -104 <= arr[i] <= 104 
// 
// Related Topics 贪心 数组 
// 👍 151 👎 0


package leetcode.editor.cn;

public class PartitionArrayIntoThreePartsWithEqualSum {
    public static void main(String[] args) {
        Solution s = new PartitionArrayIntoThreePartsWithEqualSum().new Solution();
        int[] arr = {3, 3, 6, 5, -2, 2, 5, 1, -9, 4};
        System.out.println(s.canThreePartsEqualSum(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canThreePartsEqualSum(int[] arr) {
            int sum = 0;
            for (int num : arr) {
                sum += num;
            }

            if (sum % 3 != 0) {
                return false;
            }

            int curSum = 0;
            for (int i = 0; i < arr.length; i++) {
                curSum += arr[i];
                if (curSum == sum / 3) {
                    return canTwoPart(arr, i + 1, arr.length - 1, sum / 3);
                }
            }

            return false;
        }

        private boolean canTwoPart(int[] arr, int i, int j, int target) {
            int sum = 0;
            for (int k = i; k <= j - 1; k++) {
                sum += arr[k];
                if (sum == target) {
                    return true;
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}