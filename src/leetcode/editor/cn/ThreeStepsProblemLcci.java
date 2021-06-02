//三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模100
//0000007。 
//
// 示例1: 
//
// 
// 输入：n = 3 
// 输出：4
// 说明: 有四种走法
// 
//
// 示例2: 
//
// 
// 输入：n = 5
// 输出：13
// 
//
// 提示: 
//
// 
// n范围在[1, 1000000]之间 
// 
// Related Topics 动态规划 
// 👍 57 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ThreeStepsProblemLcci {
    public static void main(String[] args) {
        Solution s = new ThreeStepsProblemLcci().new Solution();
        System.out.println(s.waysToStep(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private Map<Integer, Integer> tmp = new HashMap<>();
        private final int mod = 1000000007;

        public int waysToStep(int n) {
            if (n == 0) {
                return 1;
            }

            if (n == 1) {
                return 1;
            }

            if (n == 2) {
                return 2;
            }

            int t0 = 1;
            int t1 = 1;
            int t2 = 2;
            for (int i = 3; i <= n; i++) {
                int tmp = ((t0 + t1) % mod + t2) % mod;
                t0 = t1;
                t1 = t2;
                t2 = tmp;
            }

            return t2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
