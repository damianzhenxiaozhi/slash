//给你一个数字数组 arr 。 
//
// 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。 
//
// 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,5,1]
//输出：true
//解释：对数组重新排序得到 [1,3,5] 或者 [5,3,1] ，任意相邻两项的差分别为 2 或 -2 ，可以形成等差数列。
// 
//
// 示例 2： 
//
// 输入：arr = [1,2,4]
//输出：false
//解释：无法通过重新排序得到等差数列。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= arr.length <= 1000 
// -10^6 <= arr[i] <= 10^6 
// 
// Related Topics 排序 数组 
// 👍 11 👎 0


package leetcode.editor.cn;

public class CanMakeArithmeticProgressionFromSequence {
    public static void main(String[] args) {
        Solution s = new CanMakeArithmeticProgressionFromSequence().new Solution();
        int[] arr = new int[]{1,5,3,7};
        System.out.println(s.canMakeArithmeticProgression(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canMakeArithmeticProgression(int[] arr) {
            if (arr.length <= 2) {
                return true;
            }

            mergeSort(arr, 0, arr.length - 1);
            int diff = arr[1] - arr[0];

            for (int i = 2; i < arr.length; i++) {
                if (arr[i] - arr[i - 1] != diff) {
                    return false;
                }
            }

            return true;
        }

        private void mergeSort(int[] a, int p, int q) {
            if (p >= q) {
                return;
            }

            int r = p + (q - p) / 2;
            mergeSort(a, p, r);
            mergeSort(a, r + 1, q);

            merge(a, p, r, q);
        }

        private void merge(int[] a, int p, int r, int q) {
            int[] tmp = new int[q - p + 1];
            int i = p, j = r + 1, k = 0;

            while (i <= r && j <= q) {
                if (a[i] <= a[j]) {
                    tmp[k++] = a[i++];
                } else {
                    tmp[k++] = a[j++];
                }
            }

            while (i <= r) {
                tmp[k++] = a[i++];
            }

            while (j <= q) {
                tmp[k++] = a[j++];
            }

            for (k = 0; k < q - p + 1; k++) {
                a[p + k] = tmp[k];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
