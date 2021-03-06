//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 数组 回溯 
// 👍 614 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        Solution s = new Combinations().new Solution();
        int n = 3, k = 3;
        List<List<Integer>> result = s.combine(n, k);
        System.out.println(result.toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            backtrace(1, new int[k], 0, n, k);
            return result;
        }

        private void backtrace(int i, int[] path, int c, int n, int k) {
            if (i > n || c == k) {
                if (c == k) {
                    List<Integer> snapshot = new ArrayList<>(4);
                    for (int j = 0; j < k; j++) {
                        snapshot.add(path[j]);
                    }
                    result.add(snapshot);
                }
                return;
            }

            backtrace(i + 1, path, c, n, k);
            path[c] = i;
            backtrace(i + 1, path, c + 1, n, k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
