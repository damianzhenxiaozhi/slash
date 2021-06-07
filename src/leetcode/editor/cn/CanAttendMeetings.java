//给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，请你判断一个人是否能够参加这里面的全部会议。
//
//示例 1:
//
//输入: [[0,30],[5,10],[15,20]]
//输出: false
//1
//2
//示例 2:
//
//输入: [[7,10],[2,4]]
//输出: true

package leetcode.editor.cn;

public class CanAttendMeetings {
    public static void main(String[] args) {
        Solution s = new CanAttendMeetings().new Solution();
        int[][] intervals = new int[][]{{0, 30}, {5, 10}, {15, 20}};

        System.out.println(s.canAttendMeetings(intervals));
    }

    class Solution {
        public boolean canAttendMeetings(int[][] intervals) {
            int m = intervals.length;

            mergeSort(intervals, 0, m - 1);

            for (int i = 1; i < m; i++) {
                if (intervals[i][0] < intervals[i - 1][1]) {
                    return false;
                }
            }

            return true;
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

}
