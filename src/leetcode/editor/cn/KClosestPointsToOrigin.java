//我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。 
//
// （这里，平面上两点之间的距离是欧几里德距离。） 
//
// 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。 
//
// 
//
// 示例 1： 
//
// 输入：points = [[1,3],[-2,2]], K = 1
//输出：[[-2,2]]
//解释： 
//(1, 3) 和原点之间的距离为 sqrt(10)，
//(-2, 2) 和原点之间的距离为 sqrt(8)，
//由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
//我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
// 
//
// 示例 2： 
//
// 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
//输出：[[3,3],[-2,4]]
//（答案 [[-2,4],[3,3]] 也会被接受。）
// 
//
// 
//
// 提示： 
//
// 
// 1 <= K <= points.length <= 10000 
// -10000 < points[i][0] < 10000 
// -10000 < points[i][1] < 10000 
// 
// Related Topics 几何 数组 数学 分治 快速选择 排序 堆（优先队列） 
// 👍 255 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        Solution s = new KClosestPointsToOrigin().new Solution();
        int[][] points = new int[][]{{3,3},{5,-1},{-2,4}};
        int k = 2;
        System.out.println(Arrays.deepToString(s.kClosest(points, k)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private class Element {
            private int distance;
            private int index;

            public Element(int distance, int index) {
                this.distance = distance;
                this.index = index;
            }
        }

        public int[][] kClosest(int[][] points, int k) {
            PriorityQueue<Element> maxHeap = new PriorityQueue<>((a, b) -> b.distance - a.distance);
            int count = 0;

            for (int i = 0; i < points.length; i++) {
                int distance = distance(points[i][0], points[i][1]);
                if (count++ < k) {
                    maxHeap.add(new Element(distance, i));
                } else {
                    if (distance < maxHeap.peek().distance) {
                        maxHeap.add(new Element(distance, i));
                        maxHeap.remove();
                    }
                }
            }

            int[][] result = new int[k][2];
            for (int i = 0; i < k; i++) {
                int index = maxHeap.remove().index;
                result[i] = points[index];
            }

            return result;
        }

        private int distance(int x, int y) {
            return x * x + y * y;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
