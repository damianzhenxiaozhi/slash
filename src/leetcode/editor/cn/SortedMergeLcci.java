//给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。 
//
// 初始化 A 和 B 的元素数量分别为 m 和 n。 
//
// 示例: 
//
// 输入:
//A = [1,2,3,0,0,0], m = 3
//B = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
//
// 说明: 
//
// 
// A.length == n + m 
// 
// Related Topics 数组 双指针 
// 👍 109 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class SortedMergeLcci {
    public static void main(String[] args) {
        Solution s = new SortedMergeLcci().new Solution();
        int[] A = new int[]{1, 2, 3, 0, 0, 0};
        int[] B = new int[]{2, 5, 6};
        s.merge(A, 3, B, 3);
        System.out.println(Arrays.toString(A));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] A, int m, int[] B, int n) {
            int i = 0, j = 0, k = 0;

            int[] tmp = new int[m + n];
            while (i < m && j < n) {
                if (A[i] <= B[j]) {
                    tmp[k++] = A[i++];
                } else {
                    tmp[k++] = B[j++];
                }
            }

            while (i < m) {
                tmp[k++] = A[i++];
            }

            while (j < n) {
                tmp[k++] = B[j++];
            }

            for (k = 0; k < m + n; k++) {
                A[k] = tmp[k];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
