//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// 👍 433 👎 0


package leetcode.editor.cn;

public class ShuZuZhongDeNiXuDuiLcof {
    public static void main(String[] args) {
        Solution s = new ShuZuZhongDeNiXuDuiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reversePairs(int[] nums) {
            return 0;
        }

        private void mergeSort(int[] arr, int p, int q) {
            if (p >= q) {
                return;
            }

            int r = p + (q - p) / 2;

            mergeSort(arr, p, r - 1);
            mergeSort(arr, r, q);

            merge(arr, p, r, q);
        }

        private void merge(int[] arr, int p, int r, int q) {
            int[] tmp = new int[arr.length];

            int i = p, j = r, k = 0;

            while (i <= r-1 && j <= q) {
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
