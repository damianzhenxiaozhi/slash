//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// Related Topics 数学 双指针 枚举 
// 👍 305 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeWeiSdeLianXuZhengShuXuLieLcof {
    public static void main(String[] args) {
        Solution s = new HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
        int target = 15;
        int[][] ret = s.findContinuousSequence(target);
        for (int i = 0; i < ret.length; i++) {
            System.out.println(Arrays.toString(ret[i]));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] findContinuousSequence(int target) {
            List<List<Integer>> seqList = new ArrayList<>();
            if (target <= 2) {
                return null;
            }

            int i = 1, j = 2;
            int windowSum = i + j;
            while (j < target) {
                if (windowSum == target) {
                    List<Integer> seq = new ArrayList<>();
                    for (int k = i; k <= j; k++) {
                        seq.add(k);
                    }
                    seqList.add(seq);

                    j++;
                    windowSum += j;
                } else if (windowSum < target) {
                    j++;
                    windowSum += j;
                } else {
                    windowSum -= i;
                    i++;
                }
            }

            int[][] result = new int[seqList.size()][];
            for (int p = 0; p < seqList.size(); p++) {
                result[p] = new int[seqList.get(p).size()];
                for (int q = 0; q < seqList.get(p).size(); q++) {
                    result[p][q] = seqList.get(p).get(q);
                }
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
