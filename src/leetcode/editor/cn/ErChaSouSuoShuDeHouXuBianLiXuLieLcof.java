//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// 👍 287 👎 0


package leetcode.editor.cn;

public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof {
    public static void main(String[] args) {
        Solution s = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
        int[] postorder = new int[]{1, 3, 2, 6, 5};
        System.out.println(s.verifyPostorder(postorder));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            return verifyPostorder(postorder, 0, postorder.length - 1);
        }

        private boolean verifyPostorder(int[] postorder, int i, int j) {
            if (i >= j) {
                return true;
            }

            int k = j - 1;
            while (k >= i && postorder[k] > postorder[j]) {
                k--;
            }

            boolean leftVerify = verifyPostorder(postorder, i, k);
            if (!leftVerify) {
                return false;
            }

            boolean rightVerify = verifyPostorder(postorder, k + 1, j - 1);
            if (!rightVerify) {
                return false;
            }

            while (k >= i) {
                if (postorder[k] > postorder[j]) {
                    return false;
                }
                k--;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
