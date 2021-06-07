//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 排序 数组 
// 👍 962 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        Solution s = new MergeIntervals().new Solution();

        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = s.merge(intervals);

        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(String.format("[%d, %d],", result[i][0], result[i][1]));
        }
        System.out.println("]");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            int m = intervals.length;
            mergeSort(intervals, 0, m - 1);

            List<List<Integer>> tmp = new ArrayList<>();
            int i = 0;
            while (i < m) {
                int j = i + 1;
                int end = intervals[i][1];
                while (j < m && intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                    j = j + 1;
                }

                tmp.add(Arrays.asList(intervals[i][0], end));

                i = j;
            }

            int[][] result = new int[tmp.size()][2];
            for (i = 0; i < tmp.size(); i++) {
                result[i][0] = tmp.get(i).get(0);
                result[i][1] = tmp.get(i).get(1);
            }

            return result;
        }

        private void mergeSort(int[][] a, int p, int q) {
            if (p >= q) {
                return;
            }

            int r = p + (q - p) / 2;

            mergeSort(a, p, r);
            mergeSort(a, r + 1, q);

            merge(a, p, r, q);
        }

        private void merge(int[][] a, int p, int r, int q) {
            int[][] tmp = new int[q - p + 1][2];
            int i = p, j = r + 1, k = 0;
            while (i <= r && j <= q) {
                if (a[i][0] <= a[j][0]) {
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
