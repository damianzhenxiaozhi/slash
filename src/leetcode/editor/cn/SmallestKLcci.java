//设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。 
//
// 示例： 
//
// 输入： arr = [1,3,5,7,2,4,6,8], k = 4
//输出： [1,2,3,4]
// 
//
// 提示： 
//
// 
// 0 <= len(arr) <= 100000 
// 0 <= k <= min(100000, len(arr)) 
// 
// Related Topics 堆 排序 分治算法 
// 👍 60 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class SmallestKLcci {
    public static void main(String[] args) {
        Solution s = new SmallestKLcci().new Solution();
        int[] arr = new int[]{1, 3, 5, 7, 2, 4, 6, 8};
        int k = 4;
        int[] result = s.smallestK(arr, k);
        System.out.println(Arrays.toString(result));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] smallestK(int[] arr, int k) {
            qsort(arr, 0, arr.length - 1);

            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = arr[i];
            }

            return result;
        }

        private void qsort(int[] arr, int p, int q) {
            if (p >= q) {
                return;
            }

            int r = partition(arr, p, q);

            qsort(arr, p, r - 1);
            qsort(arr, r + 1, q);
        }

        private int partition(int[] arr, int p, int q) {
            int pivot = arr[q];

            int i = p;
            for (int j = p; j <= q - 1; j++) {
                if (arr[j] < pivot) {
                    swap(arr, i, j);
                    i++;
                }
            }

            swap(arr, i, q);
            return i;
        }

        private void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
