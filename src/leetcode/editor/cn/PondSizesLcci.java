//你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指
//相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。 
// 示例： 
// 输入：
//[
//  [0,2,1,0],
//  [0,1,0,1],
//  [1,1,0,1],
//  [0,1,0,1]
//]
//输出： [1,2,4]
// 
// 提示： 
// 
// 0 < len(land) <= 1000 
// 0 < len(land[i]) <= 1000 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 67 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PondSizesLcci {
    public static void main(String[] args) {
        Solution s = new PondSizesLcci().new Solution();
        int[][] land = {{0,2,1,0},
                {0,1,0,1},
                {1,1,0,1},
                {0,1,0,1}};
        System.out.println(Arrays.toString(s.pondSizes(land)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<Integer> counts;
        public int[] pondSizes(int[][] land) {
            counts = new ArrayList<>();
            int m = land.length;
            if (m == 0) {
                return new int[0];
            }
            int n = land[0].length;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (land[i][j] == 0) {
                        int count = dfsTraverse(land, m, n, i, j);
                        counts.add(count);
                    }
                }
            }

            counts.sort(Integer::compare);
            int[] result = new int[counts.size()];
            int i = 0;
            for (int count : counts) {
                result[i++] = count;
            }
            return result;
        }

        private int dfsTraverse(int[][] land, int m, int n, int i, int j) {
            land[i][j] = -1;

            int count = 1;
            int[][] directions = {{-1,-1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
            for (int k = 0; k < directions.length; k++) {
                int ii = i + directions[k][0];
                int jj = j + directions[k][1];
                if (ii >= 0 && ii < m && jj >= 0 && jj < n && land[ii][jj] == 0) {
                    count += dfsTraverse(land, m, n, ii, jj);
                }
            }

            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
